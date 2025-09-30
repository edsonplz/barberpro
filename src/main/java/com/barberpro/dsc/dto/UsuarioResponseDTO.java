package com.barberpro.dsc.dto;

import com.barberpro.dsc.models.Usuario;
import com.barberpro.dsc.models.enums.TipoUsuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        TipoUsuario tipo
) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo());
    }
}