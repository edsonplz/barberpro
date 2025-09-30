package com.barberpro.dsc.dto;

import com.barberpro.dsc.models.Avaliacao;
import java.time.LocalDateTime;

public record AvaliacaoResponseDTO(
        Long id,
        Integer nota,
        String comentario,
        LocalDateTime dataAvaliacao,
        String nomeCliente // Adicionamos o nome do cliente que fez a avaliação
) {
    public AvaliacaoResponseDTO(Avaliacao avaliacao) {
        this(
                avaliacao.getId(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getDataAvaliacao(),
                avaliacao.getAgendamento().getCliente().getNome() // Navegamos através do agendamento para pegar o nome do cliente
        );
    }
}