package com.barberpro.dsc.repositories;

import com.barberpro.dsc.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByClienteIdOrderByDataHoraInicioDesc(Long clienteId);

    List<Agendamento> findByBarbeiroIdOrderByDataHoraInicioDesc(Long id);

    @Query("SELECT a FROM Agendamento a WHERE a.barbeiro.id = :barbeiroId AND a.status <> 'CANCELADO' AND a.dataHoraInicio < :dataHoraFim AND a.dataHoraFim > :dataHoraInicio")
    List<Agendamento> findConflictingAppointments(Long barbeiroId, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);
}