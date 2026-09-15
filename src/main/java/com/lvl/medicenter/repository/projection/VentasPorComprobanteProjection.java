package com.lvl.medicenter.repository.projection;

import java.math.BigDecimal;

public interface VentasPorComprobanteProjection {
    String getTipoComprobante();
    Long getCantidad();
    BigDecimal getMontoTotal();
}
