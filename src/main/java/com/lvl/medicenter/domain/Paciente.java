package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;

@Entity
@Table(name = "MC_PACIENTE")
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PACIENTE_ID")
    private Integer pacienteId;

    @Column(name = "USUARIO_ID", nullable = false)
    private Integer usuarioId;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    @JdbcTypeCode(Types.CHAR)
    @Column(name = "SEXO", nullable = false, length = 1)
    private String sexo;

    @Column(name = "DIRECCION", length = 150)
    private String direccion;

    @Column(name = "CONTACTO_EMERGENCIA", length = 100)
    private String contactoEmergencia;
}
