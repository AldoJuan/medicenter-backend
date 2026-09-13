package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MC_PAGO")
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAGO_ID")
    private Integer pagoId;

    @Column(name = "CUOTA_ID", nullable = false)
    private Integer cuotaId;

    @Column(name = "FECHA_PAGO", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "MONTO_PAGADO", nullable = false)
    private BigDecimal montoPagado;

    @Column(name = "MEDIO_PAGO", nullable = false, length = 15)
    private String medioPago;

    @Column(name = "USUARIO_COBRADOR_ID", nullable = false)
    private Integer usuarioCobradorId;
}