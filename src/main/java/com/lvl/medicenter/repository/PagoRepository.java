package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByCuotaId(Integer cuotaId);
}