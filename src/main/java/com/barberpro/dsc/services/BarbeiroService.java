package com.barberpro.dsc.services;

import com.barberpro.dsc.dto.BarbeiroResponseDTO;
import com.barberpro.dsc.models.Barbeiro;
import com.barberpro.dsc.repositories.BarbeiroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Transactional(readOnly = true)
    public List<BarbeiroResponseDTO> listarTodos() {
        return barbeiroRepository.findAll().stream()
                .map(BarbeiroResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BarbeiroResponseDTO buscarPorId(Long id) {
        Barbeiro barbeiro = barbeiroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Barbeiro não encontrado com o id: " + id));
        return new BarbeiroResponseDTO(barbeiro);
    }
}