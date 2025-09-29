package com.barberpro.dsc.repositories;

import com.barberpro.dsc.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByClienteIdOrderByDataHoraInicioDesc(Long clienteId);

    List<Agendamento> findByBarbeiroIdOrderByDataHoraInicioDesc(Long id);
}