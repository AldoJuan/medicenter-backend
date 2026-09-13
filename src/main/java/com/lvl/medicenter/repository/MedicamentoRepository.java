package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}