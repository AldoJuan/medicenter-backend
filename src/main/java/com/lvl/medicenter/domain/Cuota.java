package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "MC_CUOTA")
@Data
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUOTA_ID")
    private Integer cuotaId;

    @Column(name = "FACTURA_ID", nullable = false)
    private Integer facturaId;

    @Column(name = "NUMERO_CUOTA", nullable = false)
    private Integer numeroCuota;

    @Column(name = "MONTO", nullable = false)
    private BigDecimal monto;

    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "ESTADO", nullable = false, length = 15)
    private String estado;
}