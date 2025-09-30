package com.barberpro.dsc.controllers;

import com.barberpro.dsc.dto.BarbeiroCadastroDTO;
import com.barberpro.dsc.dto.ClienteCadastroDTO;
import com.barberpro.dsc.dto.UsuarioResponseDTO;
import com.barberpro.dsc.services.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping("/clientes")
    public ResponseEntity<UsuarioResponseDTO> cadastrarCliente(@Valid @RequestBody ClienteCadastroDTO dto) {
        UsuarioResponseDTO novoUsuario = cadastroService.cadastrarCliente(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoUsuario.id()).toUri();

        return ResponseEntity.created(uri).body(novoUsuario);
    }

    @PostMapping("/barbeiros")
    public ResponseEntity<UsuarioResponseDTO> cadastrarBarbeiro(@Valid @RequestBody BarbeiroCadastroDTO dto) {
        UsuarioResponseDTO novoUsuario = cadastroService.cadastrarBarbeiro(dto);

        URI uri = ServletUriComponentsBuilder.fromPath("/api/barbeiros/{id}")
                .buildAndExpand(novoUsuario.id()).toUri();

        return ResponseEntity.created(uri).body(novoUsuario);
    }

    @GetMapping("/perfil")
    public ResponseEntity<Void> getPerfil() {
        return ResponseEntity.ok().build();
    }
}