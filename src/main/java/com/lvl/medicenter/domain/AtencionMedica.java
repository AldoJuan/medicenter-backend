package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "MC_ATENCION_MEDICA")
@Data
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATENCION_ID")
    private Integer atencionId;

    @Column(name = "CITA_ID", nullable = false)
    private Integer citaId;

    @Column(name = "FECHA_HORA_ATENCION", nullable = false)
    private LocalDateTime fechaHoraAtencion;

    @Column(name = "MOTIVO_CONSULTA", nullable = false, length = 255)
    private String motivoConsulta;

    @Column(name = "DIAGNOSTICO", nullable = false, length = 500)
    private String diagnostico;

    @Column(name = "OBSERVACIONES", length = 500)
    private String observaciones;
}