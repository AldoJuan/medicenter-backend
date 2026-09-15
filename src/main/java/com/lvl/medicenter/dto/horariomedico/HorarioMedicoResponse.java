package com.lvl.medicenter.dto.horariomedico;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioMedicoResponse {
    private Integer horarioId;
    private Integer medicoId;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}