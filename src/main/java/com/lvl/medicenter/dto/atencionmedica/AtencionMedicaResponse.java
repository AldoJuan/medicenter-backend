package com.lvl.medicenter.dto.atencionmedica;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AtencionMedicaResponse {
    private Integer atencionId;
    private Integer citaId;
    private LocalDateTime fechaHoraAtencion;
    private String motivoConsulta;
    private String diagnostico;
    private String observaciones;
}