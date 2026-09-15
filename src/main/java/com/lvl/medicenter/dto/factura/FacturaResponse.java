package com.lvl.medicenter.dto.factura;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FacturaResponse {
    private Integer facturaId;
    private Integer pacienteId;
    private Integer citaId;
    private Integer usuarioEmisorId;
    private String tipoComprobante;
    private String serie;
    private String numero;
    private LocalDateTime fechaEmision;
    private String moneda;
    private String formaPago;
    private String medioPago;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
    private String estado;
}
