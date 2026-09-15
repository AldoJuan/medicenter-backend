package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Triaje;
import com.lvl.medicenter.dto.triaje.TriajeRequest;
import com.lvl.medicenter.dto.triaje.TriajeResponse;
import com.lvl.medicenter.service.TriajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TriajeFacade {

    private final TriajeService triajeService;

    public TriajeResponse saveOrUpdate(TriajeRequest request) {
        Triaje triaje = new Triaje();
        triaje.setCitaId(request.getCitaId());
        triaje.setUsuarioTriajeId(request.getUsuarioTriajeId());
        triaje.setPresionArterial(request.getPresionArterial());
        triaje.setTemperatura(request.getTemperatura());
        triaje.setPeso(request.getPeso());
        triaje.setTalla(request.getTalla());
        triaje.setFrecuenciaCardiaca(request.getFrecuenciaCardiaca());
        triaje.setObservaciones(request.getObservaciones());
        return toResponse(triajeService.saveOrUpdateTriaje(triaje));
    }

    public TriajeResponse getById(Integer id) {
        return toResponse(triajeService.getByIdTriaje(id));
    }

    public List<TriajeResponse> findAll() {
        return triajeService.findTriaje().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        triajeService.deleteTriaje(id);
    }

    private TriajeResponse toResponse(Triaje triaje) {
        TriajeResponse response = new TriajeResponse();
        response.setTriajeId(triaje.getTriajeId());
        response.setCitaId(triaje.getCitaId());
        response.setUsuarioTriajeId(triaje.getUsuarioTriajeId());
        response.setFechaHoraTriaje(triaje.getFechaHoraTriaje());
        response.setPresionArterial(triaje.getPresionArterial());
        response.setTemperatura(triaje.getTemperatura());
        response.setPeso(triaje.getPeso());
        response.setTalla(triaje.getTalla());
        response.setFrecuenciaCardiaca(triaje.getFrecuenciaCardiaca());
        response.setObservaciones(triaje.getObservaciones());
        return response;
    }
}