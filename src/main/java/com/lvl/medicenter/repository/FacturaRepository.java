package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}