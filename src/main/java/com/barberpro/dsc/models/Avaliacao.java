package com.barberpro.dsc.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes")
@Data
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nota")
    private Integer nota;

    @Column(length = 500)
    private String comentario;

    @CreationTimestamp
    @Column(name = "data_avaliacao", updatable = false)
    private LocalDateTime dataAvaliacao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_id", nullable = false, unique = true)
    private Agendamento agendamento;
}
