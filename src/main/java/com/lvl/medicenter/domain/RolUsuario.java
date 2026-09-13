package com.lvl.medicenter.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "MC_ROL_USUARIO")
@Data
@IdClass(RolUsuario.RolUsuarioId.class)
public class RolUsuario {

    @Id
    @Column(name = "ROL_ID")
    private Integer rolId;


    @Id
    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @Data
    public static class RolUsuarioId implements Serializable{
        private Integer rolId;
        private Integer usuarioId;
    }
}
