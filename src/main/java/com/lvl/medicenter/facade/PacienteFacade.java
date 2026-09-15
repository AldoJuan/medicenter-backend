package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Paciente;
import com.lvl.medicenter.dto.paciente.PacienteRequest;
import com.lvl.medicenter.dto.paciente.PacienteResponse;
import com.lvl.medicenter.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PacienteFacade {

    private final PacienteService pacienteService;

    public PacienteResponse saveOrUpdate(PacienteRequest request) {
        Paciente paciente = new Paciente();
        paciente.setUsuarioId(request.getUsuarioId());
        paciente.setFechaNacimiento(request.getFechaNacimiento());
        paciente.setSexo(request.getSexo());
        paciente.setDireccion(request.getDireccion());
        paciente.setContactoEmergencia(request.getContactoEmergencia());
        return toResponse(pacienteService.saveOrUpdatePaciente(paciente));
    }

    public PacienteResponse getById(Integer id) {
        return toResponse(pacienteService.getByIdPaciente(id));
    }

    public List<PacienteResponse> findAll() {
        return pacienteService.findPaciente().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        pacienteService.deletePaciente(id);
    }

    private PacienteResponse toResponse(Paciente paciente) {
        PacienteResponse response = new PacienteResponse();
        response.setPacienteId(paciente.getPacienteId());
        response.setUsuarioId(paciente.getUsuarioId());
        response.setFechaNacimiento(paciente.getFechaNacimiento());
        response.setSexo(paciente.getSexo());
        response.setDireccion(paciente.getDireccion());
        response.setContactoEmergencia(paciente.getContactoEmergencia());
        return response;
    }
}