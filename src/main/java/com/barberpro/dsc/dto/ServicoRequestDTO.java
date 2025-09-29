package com.barberpro.dsc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ServicoRequestDTO(
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,
        String descricao,
        @NotNull(message = "A duração não pode ser nula")
        @Positive(message = "A duração deve ser um valor positivo")
        Integer duracaoMinutos
) { }
