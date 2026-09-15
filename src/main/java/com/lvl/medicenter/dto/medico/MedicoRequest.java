package com.lvl.medicenter.dto.medico;

import lombok.Data;

@Data
public class MedicoRequest {
    private Integer usuarioId;
    private Integer especialidadId;
    private String numColegiatura;
}