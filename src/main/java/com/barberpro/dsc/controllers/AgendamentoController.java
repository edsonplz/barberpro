package com.barberpro.dsc.controllers;

import com.barberpro.dsc.dto.AgendamentoRequestDTO;
import com.barberpro.dsc.dto.AgendamentoResponseDTO;
import com.barberpro.dsc.dto.AvaliacaoRequestDTO;
import com.barberpro.dsc.services.AgendamentoService;
import com.barberpro.dsc.services.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Void> criarAgendamento(@Valid @RequestBody AgendamentoRequestDTO dto) {
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> buscarAgendamentoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.buscarPorId(id));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id) {
        agendamentoService.cancelar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Void> concluirAgendamento(@PathVariable Long id) {
        agendamentoService.concluir(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idAgendamento}/avaliacoes")
    public ResponseEntity<Void> adicionarAvaliacao(@PathVariable Long idAgendamento,@Valid @RequestBody AvaliacaoRequestDTO dto) {
        avaliacaoService.criar(idAgendamento, dto);
        return ResponseEntity.status(201).build();
    }
}