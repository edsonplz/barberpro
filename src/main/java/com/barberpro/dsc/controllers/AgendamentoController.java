package com.barberpro.dsc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    // @Autowired
    // private AgendamentoService agendamentoService;

    // @Autowired
    // private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Void> criarAgendamento(/*@Valid @RequestBody AgendamentoRequestDTO dto*/) {
        // Lógica para criar o agendamento
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> buscarAgendamentoPorId(@PathVariable Long id) {
        // return ResponseEntity.ok(agendamentoService.buscarPorId(id));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id) {
        // agendamentoService.cancelar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Void> concluirAgendamento(@PathVariable Long id) {
        // agendamentoService.concluir(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idAgendamento}/avaliacoes")
    public ResponseEntity<Void> adicionarAvaliacao(@PathVariable Long idAgendamento, /*@Valid @RequestBody AvaliacaoRequestDTO dto*/) {
        // avaliacaoService.criar(idAgendamento, dto);
        return ResponseEntity.status(201).build();
    }
}