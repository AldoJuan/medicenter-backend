package com.lvl.medicenter.dto.reporte;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CierreCajaResponse {
    private String moneda;
    private String formaPago;
    private String medioPago;
    private Long cantidadComprobantes;
    private BigDecimal montoTotal;
}
