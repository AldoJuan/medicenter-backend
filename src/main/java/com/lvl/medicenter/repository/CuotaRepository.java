package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuotaRepository extends JpaRepository<Cuota, Integer> {

    List<Cuota> findByFacturaId(Integer facturaId);

    @Query(value = """
        SELECT cu.* FROM MC_CUOTA cu
        JOIN MC_FACTURA f ON cu.FACTURA_ID = f.FACTURA_ID
        WHERE f.PACIENTE_ID = ?1 AND cu.ESTADO = 'PENDIENTE'
        """, nativeQuery = true)
    List<Cuota> findSaldosPendientesPorPaciente(Integer pacienteId);
}
