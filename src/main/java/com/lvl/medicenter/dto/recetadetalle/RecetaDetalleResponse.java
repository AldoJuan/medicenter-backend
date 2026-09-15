package com.lvl.medicenter.dto.recetadetalle;

import lombok.Data;

@Data
public class RecetaDetalleResponse {
    private Integer recetaDetalleId;
    private Integer atencionId;
    private Integer medicamentoId;
    private String dosis;
    private String duracionTratamiento;
    private String indicaciones;
}
