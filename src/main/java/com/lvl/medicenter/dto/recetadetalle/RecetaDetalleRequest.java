package com.lvl.medicenter.dto.recetadetalle;

import lombok.Data;

@Data
public class RecetaDetalleRequest {
    private Integer atencionId;
    private Integer medicamentoId;
    private String dosis;
    private String duracionTratamiento;
    private String indicaciones;
}
