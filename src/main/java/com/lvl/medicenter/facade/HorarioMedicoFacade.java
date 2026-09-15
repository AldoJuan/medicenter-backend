package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.HorarioMedico;
import com.lvl.medicenter.dto.horariomedico.HorarioMedicoRequest;
import com.lvl.medicenter.dto.horariomedico.HorarioMedicoResponse;
import com.lvl.medicenter.service.HorarioMedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HorarioMedicoFacade {

    private final HorarioMedicoService horarioMedicoService;

    public HorarioMedicoResponse saveOrUpdate(HorarioMedicoRequest request) {
        HorarioMedico horario = new HorarioMedico();
        horario.setMedicoId(request.getMedicoId());
        horario.setDiaSemana(request.getDiaSemana());
        horario.setHoraInicio(request.getHoraInicio());
        horario.setHoraFin(request.getHoraFin());
        return toResponse(horarioMedicoService.saveOrUpdateHorarioMedico(horario));
    }

    public HorarioMedicoResponse getById(Integer id) {
        return toResponse(horarioMedicoService.getByIdHorarioMedico(id));
    }

    public List<HorarioMedicoResponse> findAll() {
        return horarioMedicoService.findHorarioMedico().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        horarioMedicoService.deleteHorarioMedico(id);
    }

    private HorarioMedicoResponse toResponse(HorarioMedico horario) {
        HorarioMedicoResponse response = new HorarioMedicoResponse();
        response.setHorarioId(horario.getHorarioId());
        response.setMedicoId(horario.getMedicoId());
        response.setDiaSemana(horario.getDiaSemana());
        response.setHoraInicio(horario.getHoraInicio());
        response.setHoraFin(horario.getHoraFin());
        return response;
    }
}