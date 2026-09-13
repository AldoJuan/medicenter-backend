package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.HorarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioMedicoRepository extends JpaRepository<HorarioMedico, Integer> {
}