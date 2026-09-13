package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.JdbcTypeCode;
import java.sql.Types;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MC_FACTURA")
@Data
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACTURA_ID")
    private Integer facturaId;

    @Column(name = "PACIENTE_ID", nullable = false)
    private Integer pacienteId;

    @Column(name = "CITA_ID")
    private Integer citaId;

    @Column(name = "USUARIO_EMISOR_ID", nullable = false)
    private Integer usuarioEmisorId;

    @Column(name = "TIPO_COMPROBANTE", nullable = false, length = 15)
    private String tipoComprobante;

    @Column(name = "SERIE", nullable = false, length = 10)
    private String serie;

    @Column(name = "NUMERO", nullable = false, length = 15)
    private String numero;

    @Column(name = "FECHA_EMISION", nullable = false)
    private LocalDateTime fechaEmision;

    @JdbcTypeCode(Types.CHAR)
    @Column(name = "MONEDA", nullable = false, length = 3)
    private String moneda;

    @Column(name = "FORMA_PAGO", nullable = false, length = 15)
    private String formaPago;

    @Column(name = "MEDIO_PAGO", length = 15)
    private String medioPago;

    @Column(name = "SUBTOTAL", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "IGV", nullable = false)
    private BigDecimal igv;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;

    @Column(name = "ESTADO", nullable = false, length = 15)
    private String estado;
}