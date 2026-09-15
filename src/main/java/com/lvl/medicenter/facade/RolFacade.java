package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Rol;
import com.lvl.medicenter.dto.rol.RolRequest;
import com.lvl.medicenter.dto.rol.RolResponse;
import com.lvl.medicenter.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RolFacade {

    private final RolService rolService;

    public RolResponse saveOrUpdate(RolRequest request) {
        Rol rol = new Rol();
        rol.setNombreRol(request.getNombreRol());
        rol.setDescripcion(request.getDescripcion());
        Rol rolGuardado = rolService.saveOrUpdateRol(rol);
        return toResponse(rolGuardado);
    }

    public RolResponse getById(Integer id) {
        return toResponse(rolService.getByIdRol(id));
    }

    public List<RolResponse> findAll() {
        return rolService.findRol().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        rolService.deleteRol(id);
    }

    private RolResponse toResponse(Rol rol) {
        RolResponse response = new RolResponse();
        response.setRolId(rol.getRolId());
        response.setNombreRol(rol.getNombreRol());
        response.setDescripcion(rol.getDescripcion());
        return response;
    }
}