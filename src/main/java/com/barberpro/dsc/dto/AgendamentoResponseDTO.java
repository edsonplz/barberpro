package com.barberpro.dsc.dto;

import com.barberpro.dsc.models.Agendamento;
import com.barberpro.dsc.models.enums.StatusAgendamento;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record AgendamentoResponseDTO(
        Long id,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        StatusAgendamento status,
        Long clienteId,
        String clienteNome,
        Long barbeiroId,
        String barbeiroNome,
        Set<ServicoResponseDTO> servicos
) {
    public AgendamentoResponseDTO(Agendamento agendamento) {
        this(
                agendamento.getId(),
                agendamento.getDataHoraInicio(),
                agendamento.getDataHoraFim(),
                agendamento.getStatus(),
                agendamento.getCliente().getId(),
                agendamento.getCliente().getNome(),
                agendamento.getBarbeiro().getId(),
                agendamento.getBarbeiro().getNome(),
                agendamento.getServicos().stream()
                        .map(ServicoResponseDTO::new)
                        .collect(Collectors.toSet())
        );
    }
}