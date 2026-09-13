package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}