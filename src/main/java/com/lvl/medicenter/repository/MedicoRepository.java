package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}