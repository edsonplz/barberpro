package com.barberpro.dsc.controllers;

import com.barberpro.dsc.dto.AgendamentoResponseDTO;
import com.barberpro.dsc.dto.AvaliacaoResponseDTO;
import com.barberpro.dsc.dto.BarbeiroResponseDTO;
import com.barberpro.dsc.services.AgendamentoService;
import com.barberpro.dsc.services.AvaliacaoService;
import com.barberpro.dsc.services.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<BarbeiroResponseDTO>> listarTodosBarbeiros() {
        return ResponseEntity.ok(barbeiroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeiroResponseDTO> buscarBarbeiroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(barbeiroService.buscarPorId(id));
    }

    @GetMapping("/{idBarbeiro}/agendamentos")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarAgendamentosPorBarbeiro(@PathVariable Long idBarbeiro) {
        return ResponseEntity.ok(agendamentoService.listarPorBarbeiro(idBarbeiro));
    }

    @GetMapping("/{idBarbeiro}/avaliacoes")
    public ResponseEntity<List<AvaliacaoResponseDTO>> listarAvaliacoesPorBarbeiro(@PathVariable Long idBarbeiro) {
        return ResponseEntity.ok(avaliacaoService.listarPorBarbeiro(idBarbeiro));
    }
}