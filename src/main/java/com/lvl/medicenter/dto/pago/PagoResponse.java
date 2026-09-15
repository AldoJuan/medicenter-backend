package com.lvl.medicenter.dto.pago;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PagoResponse {
    private Integer pagoId;
    private Integer cuotaId;
    private LocalDateTime fechaPago;
    private BigDecimal montoPagado;
    private String medioPago;
    private Integer usuarioCobradorId;
}
