package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Usuario;
import com.lvl.medicenter.dto.usuario.UsuarioRequest;
import com.lvl.medicenter.dto.usuario.UsuarioResponse;
import com.lvl.medicenter.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioFacade {

    private final UsuarioService usuarioService;

    public UsuarioResponse saveOrUpdate(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setTipoDocumento(request.getTipoDocumento());
        usuario.setNumeroDocumento(request.getNumeroDocumento());
        usuario.setNombres(request.getNombres());
        usuario.setApellidoPaterno(request.getApellidoPaterno());
        usuario.setApellidoMaterno(request.getApellidoMaterno());
        usuario.setEmail(request.getEmail());
        usuario.setPasswordHash(request.getPassword());
        usuario.setTelefono(request.getTelefono());

        Usuario usuarioGuardado = usuarioService.saveOrUpdateUsuario(usuario);

        return toResponse(usuarioGuardado);
    }

    public UsuarioResponse getById(Integer id) {
        Usuario usuario = usuarioService.getByIdUsuario(id);
        return toResponse(usuario);
    }

    private UsuarioResponse toResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setUsuarioId(usuario.getUsuarioId());
        response.setTipoDocumento(usuario.getTipoDocumento());
        response.setNumeroDocumento(usuario.getNumeroDocumento());
        response.setNombres(usuario.getNombres());
        response.setApellidoPaterno(usuario.getApellidoPaterno());
        response.setApellidoMaterno(usuario.getApellidoMaterno());
        response.setEmail(usuario.getEmail());
        response.setTelefono(usuario.getTelefono());
        response.setEstado(usuario.getEstado());
        response.setFechaCreacion(usuario.getFechaCreacion());
        return response;
    }
}