package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Integer> {
    List<FacturaDetalle> findByFacturaId(Integer facturaId);
}