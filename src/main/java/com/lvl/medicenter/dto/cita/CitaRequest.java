package com.lvl.medicenter.dto.cita;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaRequest {
    private Integer pacienteId;
    private Integer medicoId;
    private LocalDate fechaCita;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String observaciones;
}