package com.lvl.medicenter.dto.reporte;

import lombok.Data;

@Data
public class AtencionesPorMedicoResponse {
    private Integer medicoId;
    private String nombreMedico;
    private Long cantidadAtenciones;
}
