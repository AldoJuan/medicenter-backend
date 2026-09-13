package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MC_TRIAJE")
@Data
public class Triaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIAJE_ID")
    private Integer triajeId;

    @Column(name = "CITA_ID", nullable = false)
    private Integer citaId;

    @Column(name = "USUARIO_TRIAJE_ID", nullable = false)
    private Integer usuarioTriajeId;

    @Column(name = "FECHA_HORA_TRIAJE", nullable = false)
    private LocalDateTime fechaHoraTriaje;

    @Column(name = "PRESION_ARTERIAL", length = 10)
    private String presionArterial;

    @Column(name = "TEMPERATURA", precision = 4, scale = 1)
    private BigDecimal temperatura;

    @Column(name = "PESO", precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "TALLA", precision = 4, scale = 2)
    private BigDecimal talla;

    @Column(name = "FRECUENCIA_CARDIACA")
    private Integer frecuenciaCardiaca;

    @Column(name = "OBSERVACIONES", length = 255)
    private String observaciones;
}