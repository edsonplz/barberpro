package com.barberpro.dsc.services;

import com.barberpro.dsc.dto.AgendamentoRequestDTO;
import com.barberpro.dsc.dto.AgendamentoResponseDTO;
import com.barberpro.dsc.models.*;
import com.barberpro.dsc.models.enums.StatusAgendamento;
import com.barberpro.dsc.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired private AgendamentoRepository agendamentoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private BarbeiroRepository barbeiroRepository;
    @Autowired private ServicoRepository servicoRepository;

    @Transactional
    public AgendamentoResponseDTO criar(AgendamentoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        Barbeiro barbeiro = barbeiroRepository.findById(dto.barbeiroId())
                .orElseThrow(() -> new EntityNotFoundException("Barbeiro não encontrado"));
        Set<Servico> servicos = new HashSet<>(servicoRepository.findAllById(dto.servicosIds()));
        if (servicos.size() != dto.servicosIds().size()) {
            throw new EntityNotFoundException("Um ou mais serviços não foram encontrados");
        }

        int duracaoTotal = servicos.stream().mapToInt(Servico::getDuracaoMinutos).sum();
        LocalDateTime dataHoraFim = dto.dataHoraInicio().plusMinutes(duracaoTotal);

        List<Agendamento> conflitos = agendamentoRepository.findConflictingAppointments(
                barbeiro.getId(),
                dto.dataHoraInicio(),
                dataHoraFim
        );

        if (!conflitos.isEmpty()) {
            throw new IllegalStateException("O barbeiro já possui um agendamento neste horário.");
        }

        Agendamento novoAgendamento = new Agendamento();
        novoAgendamento.setCliente(cliente);
        novoAgendamento.setBarbeiro(barbeiro);
        novoAgendamento.setServicos(servicos);
        novoAgendamento.setDataHoraInicio(dto.dataHoraInicio());
        novoAgendamento.setDataHoraFim(dataHoraFim);
        novoAgendamento.setStatus(StatusAgendamento.PENDENTE);

        Agendamento agendamentoSalvo = agendamentoRepository.save(novoAgendamento);

        return new AgendamentoResponseDTO(agendamentoSalvo);
    }

    @Transactional(readOnly = true)
    public List<AgendamentoResponseDTO> listarPorCliente(Long clienteId) {
        return agendamentoRepository.findByClienteIdOrderByDataHoraInicioDesc(clienteId).stream()
                .map(AgendamentoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AgendamentoResponseDTO> listarPorBarbeiro(Long barbeiroId) {
        return agendamentoRepository.findByBarbeiroIdOrderByDataHoraInicioDesc(barbeiroId).stream()
                .map(AgendamentoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AgendamentoResponseDTO buscarPorId(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com o id: " + id));

        return new AgendamentoResponseDTO(agendamento);
    }

    @Transactional
    public void cancelar(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));

        if (agendamento.getStatus() == StatusAgendamento.CONCLUIDO) {
            throw new IllegalStateException("Não é possível cancelar um agendamento já concluído.");
        }

        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamentoRepository.save(agendamento);
    }

    @Transactional
    public void concluir(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));

        if (agendamento.getStatus() != StatusAgendamento.PENDENTE && agendamento.getStatus() != StatusAgendamento.CONFIRMADO) {
            throw new IllegalStateException("Apenas agendamentos pendentes ou confirmados podem ser concluídos.");
        }

        agendamento.setStatus(StatusAgendamento.CONCLUIDO);
        agendamentoRepository.save(agendamento);
    }
}