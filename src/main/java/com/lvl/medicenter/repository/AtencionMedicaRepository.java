package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.AtencionMedica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtencionMedicaRepository extends JpaRepository<AtencionMedica, Integer> {
}