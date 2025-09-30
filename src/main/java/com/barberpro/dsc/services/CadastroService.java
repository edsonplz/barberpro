package com.barberpro.dsc.services;

import com.barberpro.dsc.dto.BarbeiroCadastroDTO;
import com.barberpro.dsc.dto.ClienteCadastroDTO;
import com.barberpro.dsc.dto.UsuarioResponseDTO;
import com.barberpro.dsc.models.Barbeiro;
import com.barberpro.dsc.models.Cliente;
import com.barberpro.dsc.repositories.BarbeiroRepository;
import com.barberpro.dsc.repositories.ClienteRepository;
import com.barberpro.dsc.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponseDTO cadastrarCliente(ClienteCadastroDTO dto) {
        if (usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.senha());

        Cliente novoCliente = new Cliente(
                dto.nome(),
                dto.email(),
                senhaCriptografada,
                dto.telefone()
        );

        Cliente clienteSalvo = clienteRepository.save(novoCliente);

        return new UsuarioResponseDTO(clienteSalvo);
    }

    @Transactional
    public UsuarioResponseDTO cadastrarBarbeiro(BarbeiroCadastroDTO dto) {
        if (usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        String senhaCriptografada = passwordEncoder.encode(dto.senha());

        Barbeiro novoBarbeiro = new Barbeiro(
                dto.nome(),
                dto.email(),
                senhaCriptografada,
                dto.bio()
        );

        Barbeiro barbeiroSalvo = barbeiroRepository.save(novoBarbeiro);

        return new UsuarioResponseDTO(barbeiroSalvo);
    }
}