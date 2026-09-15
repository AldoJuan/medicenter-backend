package com.lvl.medicenter.dto.horariomedico;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioMedicoRequest {
    private Integer medicoId;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}