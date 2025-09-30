package com.barberpro.dsc.dto;

import com.barberpro.dsc.models.Barbeiro;

public record BarbeiroResponseDTO(
        Long id,
        String nome,
        String email,
        String bio
) {
    public BarbeiroResponseDTO(Barbeiro barbeiro) {
        this(barbeiro.getId(), barbeiro.getNome(), barbeiro.getEmail(), barbeiro.getBio());
    }
}