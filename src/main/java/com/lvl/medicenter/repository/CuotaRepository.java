package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuotaRepository extends JpaRepository<Cuota, Integer> {
    List<Cuota> findByFacturaId(Integer facturaId);
}