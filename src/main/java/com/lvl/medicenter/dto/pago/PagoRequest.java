package com.lvl.medicenter.dto.pago;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PagoRequest {
    private Integer cuotaId;
    private BigDecimal montoPagado;
    private String medioPago;
    private Integer usuarioCobradorId;
}
