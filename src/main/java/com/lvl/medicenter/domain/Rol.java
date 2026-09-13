package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MC_ROL")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROL_ID")
    private Integer rolId;

    @Column(name = "NOMBRE_ROL", nullable = false, length = 30)
    private String nombreRol;

    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;
}
