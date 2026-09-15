package com.lvl.medicenter.dto.paciente;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteRequest {
    private Integer usuarioId;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String direccion;
    private String contactoEmergencia;
}