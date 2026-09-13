package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MC_ESPECIALIDAD")
@Data
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESPECIALIDAD_ID")
    private Integer especialidadId;

    @Column(name = "CODIGO", nullable = false, length = 10)
    private String codigo;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
}