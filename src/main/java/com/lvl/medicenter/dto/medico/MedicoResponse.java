package com.lvl.medicenter.dto.medico;

import lombok.Data;

@Data
public class MedicoResponse {
    private Integer medicoId;
    private Integer usuarioId;
    private Integer especialidadId;
    private String numColegiatura;
}