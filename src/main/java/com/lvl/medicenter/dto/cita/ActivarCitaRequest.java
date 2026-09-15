package com.lvl.medicenter.dto.cita;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActivarCitaRequest {
    private BigDecimal montoAdelanto;
}