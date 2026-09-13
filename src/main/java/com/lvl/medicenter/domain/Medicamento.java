package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "MC_MEDICAMENTO")
@Data
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEDICAMENTO_ID")
    private Integer medicamentoId;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "PRECIO_VENTA", nullable = false)
    private BigDecimal precioVenta;

    @Column(name = "STOCK_ACTUAL", nullable = false)
    private Integer stockActual;

    @Column(name = "PRESENTACION", length = 50)
    private String presentacion;

    @Column(name = "CONCENTRACION", length = 30)
    private String concentracion;
}