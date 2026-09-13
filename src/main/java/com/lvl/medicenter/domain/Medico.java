package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MC_MEDICO")
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEDICO_ID")
    private Integer medicoId;

    @Column(name = "USUARIO_ID", nullable = false)
    private Integer usuarioId;

    @Column(name = "ESPECIALIDAD_ID", nullable = false)
    private Integer especialidadId;

    @Column(name = "NUM_COLEGIATURA", nullable = false, length = 20)
    private String numColegiatura;
}