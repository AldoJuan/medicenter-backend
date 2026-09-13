package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Medico;
import com.lvl.medicenter.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Transactional
    public Medico saveOrUpdateMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico getByIdMedico(Integer id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado con id: " + id));
    }

    public List<Medico> findMedico() {
        return medicoRepository.findAll();
    }

    @Transactional
    public void deleteMedico(Integer id) {
        medicoRepository.deleteById(id);
    }
}