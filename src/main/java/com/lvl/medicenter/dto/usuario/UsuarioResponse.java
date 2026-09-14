package com.lvl.medicenter.dto.usuario;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioResponse {
    private Integer usuarioId;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String telefono;
    private String estado;
    private LocalDateTime fechaCreacion;
}