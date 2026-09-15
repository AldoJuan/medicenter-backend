package com.lvl.medicenter.dto.cuota;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CuotaResponse {
    private Integer cuotaId;
    private Integer facturaId;
    private Integer numeroCuota;
    private BigDecimal monto;
    private LocalDate fechaVencimiento;
    private String estado;
}
