package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.RecetaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaDetalleRepository extends JpaRepository<RecetaDetalle, Integer> {
    List<RecetaDetalle> findByAtencionId(Integer atencionId);
}