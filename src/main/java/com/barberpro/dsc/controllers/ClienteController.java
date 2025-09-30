package com.barberpro.dsc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    // @Autowired
    // private AgendamentoService agendamentoService;

    @GetMapping("/{idCliente}/agendamentos")
    public ResponseEntity<Void> listarAgendamentosPorCliente(@PathVariable Long idCliente) {
        // return ResponseEntity.ok(agendamentoService.listarPorCliente(idCliente));
        return ResponseEntity.ok().build();
    }
}
