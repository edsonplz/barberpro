package com.barberpro.dsc.dto;

import com.barberpro.dsc.models.Servico;
import java.math.BigDecimal;

public record ServicoResponseDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer duracaoMinutos
) {
    public ServicoResponseDTO(Servico servico) {
        this(servico.getId(), servico.getNome(), servico.getDescricao(), servico.getPreco(), servico.getDuracaoMinutos());
    }
}