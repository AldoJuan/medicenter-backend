package com.lvl.medicenter.dto.triaje;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TriajeResponse {
    private Integer triajeId;
    private Integer citaId;
    private Integer usuarioTriajeId;
    private LocalDateTime fechaHoraTriaje;
    private String presionArterial;
    private BigDecimal temperatura;
    private BigDecimal peso;
    private BigDecimal talla;
    private Integer frecuenciaCardiaca;
    private String observaciones;
}