package com.barberpro.dsc.services;

import com.barberpro.dsc.models.Usuario;
import com.barberpro.dsc.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + username));

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getTipo().name());

        System.out.println("Usuário '" + username + "' carregado com a permissão: " + authority.getAuthority());

        return new User(
                usuario.getEmail(),
                usuario.getSenhaHash(),
                Collections.singletonList(authority)
        );
    }
}