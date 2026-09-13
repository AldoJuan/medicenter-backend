package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.JdbcTypeCode;
import java.sql.Types;

import java.time.LocalDateTime;

@Entity
@Table(name= "MC_USUARIO")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @JdbcTypeCode(Types.CHAR)
    @Column(name = "TIPO_DOCUMENTO", nullable = false, length = 2)
    private String tipoDocumento;

    @Column(name = "NUMERO_DOCUMENTO", nullable = false, length = 15)
    private String numeroDocumento;

    @Column(name = "NOMBRES", nullable = false, length = 100)
    private String nombres;

    @Column(name = "APELLIDO_PATERNO", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO", nullable = false, length = 50)
    private String apellidoMaterno;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "PASSWORD_HASH", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @JdbcTypeCode(Types.CHAR)
    @Column(name = "ESTADO", nullable = false, length = 1)
    private String estado;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;
}
