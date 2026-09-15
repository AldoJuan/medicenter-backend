package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.RolUsuario;
import com.lvl.medicenter.dto.rolusuario.RolUsuarioRequest;
import com.lvl.medicenter.dto.rolusuario.RolUsuarioResponse;
import com.lvl.medicenter.service.RolUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RolUsuarioFacade {

    private final RolUsuarioService rolUsuarioService;

    public RolUsuarioResponse saveOrUpdate(RolUsuarioRequest request) {
        RolUsuario rolUsuario = new RolUsuario();
        rolUsuario.setRolId(request.getRolId());
        rolUsuario.setUsuarioId(request.getUsuarioId());
        return toResponse(rolUsuarioService.saveOrUpdateRolUsuario(rolUsuario));
    }

    public List<RolUsuarioResponse> findAll() {
        return rolUsuarioService.findRolUsuario().stream().map(this::toResponse).toList();
    }

    public void delete(Integer rolId, Integer usuarioId) {
        RolUsuario.RolUsuarioId id = new RolUsuario.RolUsuarioId();
        id.setRolId(rolId);
        id.setUsuarioId(usuarioId);
        rolUsuarioService.deleteRolUsuario(id);
    }

    private RolUsuarioResponse toResponse(RolUsuario rolUsuario) {
        RolUsuarioResponse response = new RolUsuarioResponse();
        response.setRolId(rolUsuario.getRolId());
        response.setUsuarioId(rolUsuario.getUsuarioId());
        return response;
    }
}