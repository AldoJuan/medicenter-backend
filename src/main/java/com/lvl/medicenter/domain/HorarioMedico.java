package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "MC_HORARIO_MEDICO")
@Data
public class HorarioMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HORARIO_ID")
    private Integer horarioId;

    @Column(name = "MEDICO_ID", nullable = false)
    private Integer medicoId;

    @Column(name = "DIA_SEMANA", nullable = false, length = 10)
    private String diaSemana;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private LocalTime horaFin;
}