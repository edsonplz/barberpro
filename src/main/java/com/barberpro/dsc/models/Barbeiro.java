package com.barberpro.dsc.models;

import com.barberpro.dsc.models.enums.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "barbeiros")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Barbeiro extends Usuario {
    private String bio;
    @Column(name = "foto_perfil")
    private String fotoPerfil;
    @Column(name = "media_avaliacao")
    private Double mediaAvaliacao;

    public Barbeiro (String nome, String email, String senhaHash, String bio) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenhaHash(senhaHash);
        this.setTipo(TipoUsuario.BARBEIRO);
        this.setBio(bio);
        this.mediaAvaliacao = 0.0;
    }
}
