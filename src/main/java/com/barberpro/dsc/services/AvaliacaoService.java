package com.barberpro.dsc.services;

import com.barberpro.dsc.dto.AvaliacaoRequestDTO;
import com.barberpro.dsc.dto.AvaliacaoResponseDTO;
import com.barberpro.dsc.models.Agendamento;
import com.barberpro.dsc.models.Avaliacao;
import com.barberpro.dsc.models.Barbeiro;
import com.barberpro.dsc.models.enums.StatusAgendamento;
import com.barberpro.dsc.repositories.AgendamentoRepository;
import com.barberpro.dsc.repositories.AvaliacaoRepository;
import com.barberpro.dsc.repositories.BarbeiroRepository; // IMPORTAR
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List; // IMPORTAR
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    @Autowired private AvaliacaoRepository avaliacaoRepository;
    @Autowired private AgendamentoRepository agendamentoRepository;
    @Autowired private BarbeiroRepository barbeiroRepository; // INJETAR

    @Transactional
    public void criar(Long idAgendamento, AvaliacaoRequestDTO dto) {
        Agendamento agendamento = agendamentoRepository.findById(idAgendamento)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));

        if (agendamento.getStatus() != StatusAgendamento.CONCLUIDO) {
            throw new IllegalStateException("Só é possível avaliar agendamentos concluídos.");
        }
        if (agendamento.getAvaliacao() != null) {
            throw new IllegalStateException("Este agendamento já foi avaliado.");
        }

        Avaliacao novaAvaliacao = new Avaliacao();
        novaAvaliacao.setNota(dto.nota());
        novaAvaliacao.setComentario(dto.comentario());
        novaAvaliacao.setAgendamento(agendamento);
        avaliacaoRepository.save(novaAvaliacao);

        recalcularMediaBarbeiro(agendamento.getBarbeiro());
    }

    @Transactional(readOnly = true)
    public List<AvaliacaoResponseDTO> listarPorBarbeiro(Long idBarbeiro) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByAgendamentoBarbeiroId(idBarbeiro);

        return avaliacoes.stream()
                .map(AvaliacaoResponseDTO::new)
                .collect(Collectors.toList());
    }

    private void recalcularMediaBarbeiro(Barbeiro barbeiro) {
        List<Avaliacao> avaliacoesDoBarbeiro = avaliacaoRepository.findByAgendamentoBarbeiroId(barbeiro.getId());

        double media = avaliacoesDoBarbeiro.stream()
                .mapToInt(Avaliacao::getNota)
                .average()
                .orElse(0.0); // Se não houver avaliações, a média é 0

        barbeiro.setMediaAvaliacao(media);
        barbeiroRepository.save(barbeiro);
    }
}