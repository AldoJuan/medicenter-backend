package com.lvl.medicenter.dto.atencionmedica;

import lombok.Data;

@Data
public class AtencionMedicaRequest {
    private Integer citaId;
    private String motivoConsulta;
    private String diagnostico;
    private String observaciones;
}