package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "MC_FACTURA_DETALLE")
@Data
public class FacturaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACTURA_DETALLE_ID")
    private Integer facturaDetalleId;

    @Column(name = "FACTURA_ID", nullable = false)
    private Integer facturaId;

    @Column(name = "MEDICAMENTO_ID")
    private Integer medicamentoId;

    @Column(name = "TIPO_ITEM", nullable = false, length = 20)
    private String tipoItem;

    @Column(name = "DESCRIPCION", nullable = false, length = 150)
    private String descripcion;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "SUBTOTAL", nullable = false)
    private BigDecimal subtotal;
}