package com.lvl.medicenter.dto.reporte;

import lombok.Data;

@Data
public class AtencionesPorEspecialidadResponse {
    private Integer especialidadId;
    private String nombreEspecialidad;
    private Long cantidadAtenciones;
}
