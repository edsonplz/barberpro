package com.barberpro.dsc.controllers;

import com.barberpro.dsc.dto.AgendamentoResponseDTO;
import com.barberpro.dsc.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/{idCliente}/agendamentos")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarAgendamentosPorCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(agendamentoService.listarPorCliente(idCliente));
    }
}
