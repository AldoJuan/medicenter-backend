package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Paciente;
import com.lvl.medicenter.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Transactional
    public Paciente saveOrUpdatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente getByIdPaciente(Integer id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));
    }

    public List<Paciente> findPaciente() {
        return pacienteRepository.findAll();
    }

    @Transactional
    public void deletePaciente(Integer id) {
        pacienteRepository.deleteById(id);
    }
}