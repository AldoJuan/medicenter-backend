package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Especialidad;
import com.lvl.medicenter.repository.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    @Transactional
    public Especialidad saveOrUpdateEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public Especialidad getByIdEspecialidad(Integer id) {
        return especialidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada con id: " + id));
    }

    public List<Especialidad> findEspecialidad() {
        return especialidadRepository.findAll();
    }

    @Transactional
    public void deleteEspecialidad(Integer id) {
        especialidadRepository.deleteById(id);
    }
}