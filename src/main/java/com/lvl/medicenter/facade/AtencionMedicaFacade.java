package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.AtencionMedica;
import com.lvl.medicenter.dto.atencionmedica.AtencionMedicaRequest;
import com.lvl.medicenter.dto.atencionmedica.AtencionMedicaResponse;
import com.lvl.medicenter.service.AtencionMedicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AtencionMedicaFacade {

    private final AtencionMedicaService atencionMedicaService;

    public AtencionMedicaResponse saveOrUpdate(AtencionMedicaRequest request) {
        AtencionMedica atencion = new AtencionMedica();
        atencion.setCitaId(request.getCitaId());
        atencion.setMotivoConsulta(request.getMotivoConsulta());
        atencion.setDiagnostico(request.getDiagnostico());
        atencion.setObservaciones(request.getObservaciones());
        return toResponse(atencionMedicaService.saveOrUpdateAtencionMedica(atencion));
    }

    public AtencionMedicaResponse getById(Integer id) {
        return toResponse(atencionMedicaService.getByIdAtencionMedica(id));
    }

    public List<AtencionMedicaResponse> findAll() {
        return atencionMedicaService.findAtencionMedica().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        atencionMedicaService.deleteAtencionMedica(id);
    }

    private AtencionMedicaResponse toResponse(AtencionMedica atencion) {
        AtencionMedicaResponse response = new AtencionMedicaResponse();
        response.setAtencionId(atencion.getAtencionId());
        response.setCitaId(atencion.getCitaId());
        response.setFechaHoraAtencion(atencion.getFechaHoraAtencion());
        response.setMotivoConsulta(atencion.getMotivoConsulta());
        response.setDiagnostico(atencion.getDiagnostico());
        response.setObservaciones(atencion.getObservaciones());
        return response;
    }
}