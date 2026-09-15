package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.RecetaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecetaDetalleRepository extends JpaRepository<RecetaDetalle, Integer> {

    List<RecetaDetalle> findByAtencionId(Integer atencionId);

    @Query(value = """
        SELECT rd.*
        FROM MC_RECETA_DETALLE rd
        JOIN MC_ATENCION_MEDICA am
            ON rd.ATENCION_ID = am.ATENCION_ID
        JOIN MC_CITA c
            ON am.CITA_ID = c.CITA_ID
        WHERE c.PACIENTE_ID = ?1
        """, nativeQuery = true)
    List<RecetaDetalle> findByPacienteId(Integer pacienteId);
}