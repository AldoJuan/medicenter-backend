package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.RecetaDetalle;
import com.lvl.medicenter.dto.recetadetalle.RecetaDetalleRequest;
import com.lvl.medicenter.dto.recetadetalle.RecetaDetalleResponse;
import com.lvl.medicenter.service.RecetaDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecetaDetalleFacade {

    private final RecetaDetalleService recetaDetalleService;

    public RecetaDetalleResponse saveOrUpdate(RecetaDetalleRequest request) {
        RecetaDetalle receta = new RecetaDetalle();
        receta.setAtencionId(request.getAtencionId());
        receta.setMedicamentoId(request.getMedicamentoId());
        receta.setDosis(request.getDosis());
        receta.setDuracionTratamiento(request.getDuracionTratamiento());
        receta.setIndicaciones(request.getIndicaciones());
        return toResponse(recetaDetalleService.saveOrUpdateRecetaDetalle(receta));
    }

    public RecetaDetalleResponse getById(Integer id) {
        return toResponse(recetaDetalleService.getByIdRecetaDetalle(id));
    }

    public List<RecetaDetalleResponse> findByAtencion(Integer atencionId) {
        return recetaDetalleService.findByAtencionRecetaDetalle(atencionId).stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        recetaDetalleService.deleteRecetaDetalle(id);
    }

    private RecetaDetalleResponse toResponse(RecetaDetalle receta) {
        RecetaDetalleResponse response = new RecetaDetalleResponse();
        response.setRecetaDetalleId(receta.getRecetaDetalleId());
        response.setAtencionId(receta.getAtencionId());
        response.setMedicamentoId(receta.getMedicamentoId());
        response.setDosis(receta.getDosis());
        response.setDuracionTratamiento(receta.getDuracionTratamiento());
        response.setIndicaciones(receta.getIndicaciones());
        return response;
    }
}
