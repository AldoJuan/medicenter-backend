package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "MC_CITA")
@Data
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITA_ID")
    private Integer citaId;

    @Column(name = "PACIENTE_ID", nullable = false)
    private Integer pacienteId;

    @Column(name = "MEDICO_ID", nullable = false)
    private Integer medicoId;

    @Column(name = "FECHA_CITA", nullable = false)
    private LocalDate fechaCita;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private LocalTime horaFin;

    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado;

    @Column(name = "MONTO_ADELANTO")
    private BigDecimal montoAdelanto;

    @Column(name = "FECHA_RESERVA", nullable = false)
    private LocalDateTime fechaReserva;

    @Column(name = "OBSERVACIONES", length = 255)
    private String observaciones;
}