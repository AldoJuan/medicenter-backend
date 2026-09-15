package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Cita;
import com.lvl.medicenter.dto.cita.CitaRequest;
import com.lvl.medicenter.dto.cita.CitaResponse;
import com.lvl.medicenter.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CitaFacade {

    private final CitaService citaService;

    public CitaResponse saveOrUpdate(CitaRequest request) {
        Cita cita = new Cita();
        cita.setPacienteId(request.getPacienteId());
        cita.setMedicoId(request.getMedicoId());
        cita.setFechaCita(request.getFechaCita());
        cita.setHoraInicio(request.getHoraInicio());
        cita.setHoraFin(request.getHoraFin());
        cita.setObservaciones(request.getObservaciones());
        return toResponse(citaService.saveOrUpdateCita(cita));
    }

    public CitaResponse activar(Integer id, BigDecimal montoAdelanto) {
        return toResponse(citaService.activarCita(id, montoAdelanto));
    }

    public CitaResponse getById(Integer id) {
        return toResponse(citaService.getByIdCita(id));
    }

    public List<CitaResponse> findAll() {
        return citaService.findCita().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        citaService.deleteCita(id);
    }

    private CitaResponse toResponse(Cita cita) {
        CitaResponse response = new CitaResponse();
        response.setCitaId(cita.getCitaId());
        response.setPacienteId(cita.getPacienteId());
        response.setMedicoId(cita.getMedicoId());
        response.setFechaCita(cita.getFechaCita());
        response.setHoraInicio(cita.getHoraInicio());
        response.setHoraFin(cita.getHoraFin());
        response.setEstado(cita.getEstado());
        response.setMontoAdelanto(cita.getMontoAdelanto());
        response.setFechaReserva(cita.getFechaReserva());
        response.setObservaciones(cita.getObservaciones());
        return response;
    }
}