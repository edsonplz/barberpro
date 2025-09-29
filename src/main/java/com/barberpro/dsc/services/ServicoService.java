package com.barberpro.dsc.services;

import com.barberpro.dsc.dto.ServicoResponseDTO;
import com.barberpro.dsc.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public List<ServicoResponseDTO> listarTodos() {
        return servicoRepository.findAll().stream()
                .map(ServicoResponseDTO::new)
                .collect(Collectors.toList());
    }
}
