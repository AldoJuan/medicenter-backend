package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByMedicoIdAndFechaCitaAndEstadoNot(Integer medicoId, LocalDate fechaCita, String estado);
}