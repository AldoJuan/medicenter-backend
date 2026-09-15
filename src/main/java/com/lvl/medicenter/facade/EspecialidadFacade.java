package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Especialidad;
import com.lvl.medicenter.dto.especialidad.EspecialidadRequest;
import com.lvl.medicenter.dto.especialidad.EspecialidadResponse;
import com.lvl.medicenter.service.EspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EspecialidadFacade {

    private final EspecialidadService especialidadService;

    public EspecialidadResponse saveOrUpdate(EspecialidadRequest request) {
        Especialidad especialidad = new Especialidad();
        especialidad.setCodigo(request.getCodigo());
        especialidad.setNombre(request.getNombre());
        return toResponse(especialidadService.saveOrUpdateEspecialidad(especialidad));
    }

    public EspecialidadResponse getById(Integer id) {
        return toResponse(especialidadService.getByIdEspecialidad(id));
    }

    public List<EspecialidadResponse> findAll() {
        return especialidadService.findEspecialidad().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        especialidadService.deleteEspecialidad(id);
    }

    private EspecialidadResponse toResponse(Especialidad especialidad) {
        EspecialidadResponse response = new EspecialidadResponse();
        response.setEspecialidadId(especialidad.getEspecialidadId());
        response.setCodigo(especialidad.getCodigo());
        response.setNombre(especialidad.getNombre());
        return response;
    }
}