package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.AtencionMedica;
import com.lvl.medicenter.repository.projection.AtencionesPorEspecialidadProjection;
import com.lvl.medicenter.repository.projection.AtencionesPorMedicoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtencionMedicaRepository extends JpaRepository<AtencionMedica, Integer> {

    @Query(value = """
        SELECT m.MEDICO_ID as medicoId,
               u.NOMBRES + ' ' + u.APELLIDO_PATERNO + ' ' + u.APELLIDO_MATERNO as nombreMedico,
               COUNT(am.ATENCION_ID) as cantidadAtenciones
        FROM MC_ATENCION_MEDICA am
        JOIN MC_CITA c ON am.CITA_ID = c.CITA_ID
        JOIN MC_MEDICO m ON c.MEDICO_ID = m.MEDICO_ID
        JOIN MC_USUARIO u ON m.USUARIO_ID = u.USUARIO_ID
        GROUP BY m.MEDICO_ID, u.NOMBRES, u.APELLIDO_PATERNO, u.APELLIDO_MATERNO
        ORDER BY cantidadAtenciones DESC
        """, nativeQuery = true)
    List<AtencionesPorMedicoProjection> countAtencionesPorMedico();

    @Query(value = """
        SELECT TOP (?1) m.MEDICO_ID as medicoId,
               u.NOMBRES + ' ' + u.APELLIDO_PATERNO + ' ' + u.APELLIDO_MATERNO as nombreMedico,
               COUNT(am.ATENCION_ID) as cantidadAtenciones
        FROM MC_ATENCION_MEDICA am
        JOIN MC_CITA c ON am.CITA_ID = c.CITA_ID
        JOIN MC_MEDICO m ON c.MEDICO_ID = m.MEDICO_ID
        JOIN MC_USUARIO u ON m.USUARIO_ID = u.USUARIO_ID
        GROUP BY m.MEDICO_ID, u.NOMBRES, u.APELLIDO_PATERNO, u.APELLIDO_MATERNO
        ORDER BY cantidadAtenciones DESC
        """, nativeQuery = true)
    List<AtencionesPorMedicoProjection> rankingMedicosPorAtenciones(int limite);

    @Query(value = """
        SELECT e.ESPECIALIDAD_ID as especialidadId,
               e.NOMBRE as nombreEspecialidad,
               COUNT(am.ATENCION_ID) as cantidadAtenciones
        FROM MC_ATENCION_MEDICA am
        JOIN MC_CITA c ON am.CITA_ID = c.CITA_ID
        JOIN MC_MEDICO m ON c.MEDICO_ID = m.MEDICO_ID
        JOIN MC_ESPECIALIDAD e ON m.ESPECIALIDAD_ID = e.ESPECIALIDAD_ID
        GROUP BY e.ESPECIALIDAD_ID, e.NOMBRE
        ORDER BY cantidadAtenciones DESC
        """, nativeQuery = true)
    List<AtencionesPorEspecialidadProjection> rankingEspecialidadesPorAtenciones();
}
