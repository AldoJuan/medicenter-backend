package com.lvl.medicenter.dto.facturadetalle;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class FacturaDetalleResponse {
    private Integer facturaDetalleId;
    private Integer facturaId;
    private Integer medicamentoId;
    private String tipoItem;
    private String descripcion;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
