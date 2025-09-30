package com.barberpro.dsc.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

public record AgendamentoRequestDTO(
        @NotNull Long clienteId,
        @NotNull Long barbeiroId,
        @NotEmpty Set<Long> servicosIds,
        @NotNull @Future LocalDateTime dataHoraInicio
) {}