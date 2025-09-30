package com.barberpro.dsc.controllers;

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
    public ResponseEntity<Void> cadastrarBarbeiro(/*@Valid @RequestBody BarbeiroCadastroDTO dto*/) {
        // Lógica para chamar o service e cadastrar um barbeiro
        // Esta rota deverá ser protegida para ser acessada apenas por administradores
        return ResponseEntity.status(201).build(); // Retorna 201 Created
    }

    @GetMapping("/perfil")
    public ResponseEntity<Void> getPerfil() {
        // Lógica para buscar os dados do usuário que está logado (usando o Spring Security Context)
        return ResponseEntity.ok().build(); // Retorna o DTO com os dados do usuário
    }
}