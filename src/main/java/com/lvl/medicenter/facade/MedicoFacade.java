package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Medico;
import com.lvl.medicenter.dto.medico.MedicoRequest;
import com.lvl.medicenter.dto.medico.MedicoResponse;
import com.lvl.medicenter.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MedicoFacade {

    private final MedicoService medicoService;

    public MedicoResponse saveOrUpdate(MedicoRequest request) {
        Medico medico = new Medico();
        medico.setUsuarioId(request.getUsuarioId());
        medico.setEspecialidadId(request.getEspecialidadId());
        medico.setNumColegiatura(request.getNumColegiatura());
        return toResponse(medicoService.saveOrUpdateMedico(medico));
    }

    public MedicoResponse getById(Integer id) {
        return toResponse(medicoService.getByIdMedico(id));
    }

    public List<MedicoResponse> findAll() {
        return medicoService.findMedico().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        medicoService.deleteMedico(id);
    }

    private MedicoResponse toResponse(Medico medico) {
        MedicoResponse response = new MedicoResponse();
        response.setMedicoId(medico.getMedicoId());
        response.setUsuarioId(medico.getUsuarioId());
        response.setEspecialidadId(medico.getEspecialidadId());
        response.setNumColegiatura(medico.getNumColegiatura());
        return response;
    }
}