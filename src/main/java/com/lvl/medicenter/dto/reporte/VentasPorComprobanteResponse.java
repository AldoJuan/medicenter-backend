package com.lvl.medicenter.dto.reporte;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class VentasPorComprobanteResponse {
    private String tipoComprobante;
    private Long cantidad;
    private BigDecimal montoTotal;
}
