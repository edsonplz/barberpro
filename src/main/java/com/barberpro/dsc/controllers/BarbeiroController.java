package com.barberpro.dsc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barbeiros")
public class BarbeiroController {

    // @Autowired
    // private BarbeiroService barbeiroService;

    // @Autowired
    // private AgendamentoService agendamentoService;

    // @Autowired
    // private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<Void> listarTodosBarbeiros() {
        // return ResponseEntity.ok(barbeiroService.listarTodos());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> buscarBarbeiroPorId(@PathVariable Long id) {
        // return ResponseEntity.ok(barbeiroService.buscarPorId(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idBarbeiro}/agendamentos")
    public ResponseEntity<Void> listarAgendamentosPorBarbeiro(@PathVariable Long idBarbeiro) {
        // return ResponseEntity.ok(agendamentoService.listarPorBarbeiro(idBarbeiro));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idBarbeiro}/avaliacoes")
    public ResponseEntity<Void> listarAvaliacoesPorBarbeiro(@PathVariable Long idBarbeiro) {
        // return ResponseEntity.ok(avaliacaoService.listarPorBarbeiro(idBarbeiro));
        return ResponseEntity.ok().build();
    }
}