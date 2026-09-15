package com.lvl.medicenter.repository.projection;

import java.math.BigDecimal;

public interface CierreCajaProjection {
    String getMoneda();
    String getFormaPago();
    String getMedioPago();
    Long getCantidadComprobantes();
    BigDecimal getMontoTotal();
}
