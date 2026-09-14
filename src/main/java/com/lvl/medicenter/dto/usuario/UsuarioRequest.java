package com.lvl.medicenter.dto.usuario;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String password;
    private String telefono;
}