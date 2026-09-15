package com.lvl.medicenter.dto.factura;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class FacturaRequest {
    private Integer pacienteId;
    private Integer citaId;
    private Integer usuarioEmisorId;
    private String tipoComprobante;
    private String serie;
    private String numero;
    private String moneda;
    private String formaPago;
    private String medioPago;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
}
