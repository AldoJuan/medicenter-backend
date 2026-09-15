package com.lvl.medicenter.dto.triaje;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TriajeRequest {
    private Integer citaId;
    private Integer usuarioTriajeId;
    private String presionArterial;
    private BigDecimal temperatura;
    private BigDecimal peso;
    private BigDecimal talla;
    private Integer frecuenciaCardiaca;
    private String observaciones;
}