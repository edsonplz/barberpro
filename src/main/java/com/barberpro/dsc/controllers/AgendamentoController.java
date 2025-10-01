package com.barberpro.dsc.controllers;

import com.barberpro.dsc.dto.AgendamentoRequestDTO;
import com.barberpro.dsc.dto.AgendamentoResponseDTO;
import com.barberpro.dsc.dto.AvaliacaoRequestDTO;
import com.barberpro.dsc.services.AgendamentoService;
import com.barberpro.dsc.services.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/api/agendamentos")
@Tag(name = "Agendamentos", description = "Endpoints para gerenciamento de agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Operation(summary = "Cria um novo agendamento", description = "Registra um novo agendamento para um cliente com um barbeiro e serviços específicos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Agendamento criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Regra de negócio violada (ex: horário indisponível)"),
            @ApiResponse(responseCode = "422", description = "Dados de entrada inválidos")
    })

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@Valid @RequestBody AgendamentoRequestDTO dto) {
        AgendamentoResponseDTO novoAgendamento = agendamentoService.criar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoAgendamento.id()).toUri();
        return ResponseEntity.created(uri).body(novoAgendamento);
    }

    @Operation(summary = "Busca um agendamento por ID", description = "Retorna os detalhes de um agendamento específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agendamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado")
    })

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