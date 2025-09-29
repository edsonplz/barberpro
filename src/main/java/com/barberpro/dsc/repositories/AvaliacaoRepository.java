package com.barberpro.dsc.repositories;

import com.barberpro.dsc.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByAgendamentoBarbeiroId(Long id);
}
