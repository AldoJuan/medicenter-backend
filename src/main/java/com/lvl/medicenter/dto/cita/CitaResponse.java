package com.lvl.medicenter.dto.cita;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class CitaResponse {
    private Integer citaId;
    private Integer pacienteId;
    private Integer medicoId;
    private LocalDate fechaCita;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;
    private BigDecimal montoAdelanto;
    private LocalDateTime fechaReserva;
    private String observaciones;
}