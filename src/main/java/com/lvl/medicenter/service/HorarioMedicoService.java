package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.HorarioMedico;
import com.lvl.medicenter.repository.HorarioMedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioMedicoService {

    private final HorarioMedicoRepository horarioMedicoRepository;

    @Transactional
    public HorarioMedico saveOrUpdateHorarioMedico(HorarioMedico horarioMedico) {
        return horarioMedicoRepository.save(horarioMedico);
    }

    public HorarioMedico getByIdHorarioMedico(Integer id) {
        return horarioMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
    }

    public List<HorarioMedico> findHorarioMedico() {
        return horarioMedicoRepository.findAll();
    }

    @Transactional
    public void deleteHorarioMedico(Integer id) {
        horarioMedicoRepository.deleteById(id);
    }
}