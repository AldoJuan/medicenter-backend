package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MC_RECETA_DETALLE")
@Data
public class RecetaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECETA_DETALLE_ID")
    private Integer recetaDetalleId;

    @Column(name = "ATENCION_ID", nullable = false)
    private Integer atencionId;

    @Column(name = "MEDICAMENTO_ID", nullable = false)
    private Integer medicamentoId;

    @Column(name = "DOSIS", nullable = false, length = 50)
    private String dosis;

    @Column(name = "DURACION_TRATAMIENTO", length = 30)
    private String duracionTratamiento;

    @Column(name = "INDICACIONES", length = 255)
    private String indicaciones;
}