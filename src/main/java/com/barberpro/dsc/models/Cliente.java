package com.barberpro.dsc.models;

import com.barberpro.dsc.models.enums.TipoUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Usuario {
    private String telefone;

    public Cliente(String nome, String email, String senhaHash,  String telefone) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenhaHash(senhaHash);
        this.setTipo(TipoUsuario.CLIENTE);
        this.telefone = telefone;
    }
}
