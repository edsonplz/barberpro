package com.barberpro.dsc.services;

import com.barberpro.dsc.dto.ServicoRequestDTO;
import com.barberpro.dsc.dto.ServicoResponseDTO;
import com.barberpro.dsc.models.Servico;
import com.barberpro.dsc.repositories.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public List<ServicoResponseDTO> listarTodos() {
        return servicoRepository.findAll().stream()
                .map(ServicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ServicoResponseDTO criar(ServicoRequestDTO dto) {
        Servico novoServico = new Servico();
        novoServico.setNome(dto.nome());
        novoServico.setDescricao(dto.descricao());
        novoServico.setDuracaoMinutos(dto.duracaoMinutos());

        Servico servicoSalvo = servicoRepository.save(novoServico);
        return new ServicoResponseDTO(servicoSalvo);
    }

    @Transactional
    public ServicoResponseDTO atualizar(Long id, ServicoRequestDTO dto) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado com o id: " + id));

        servico.setNome(dto.nome());
        servico.setDescricao(dto.descricao());
        servico.setDuracaoMinutos(dto.duracaoMinutos());

        Servico servicoAtualizado = servicoRepository.save(servico);
        return new ServicoResponseDTO(servicoAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Serviço não encontrado com o id: " + id);
        }
        servicoRepository.deleteById(id);
    }
}