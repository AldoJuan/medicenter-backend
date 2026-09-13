package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Triaje;
import com.lvl.medicenter.repository.TriajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TriajeService {

    private final TriajeRepository triajeRepository;

    @Transactional
    public Triaje saveOrUpdateTriaje(Triaje triaje) {
        if (triaje.getTriajeId() == null) {
            triaje.setFechaHoraTriaje(LocalDateTime.now());
        }
        return triajeRepository.save(triaje);
    }

    public Triaje getByIdTriaje(Integer id) {
        return triajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Triaje no encontrado con id: " + id));
    }

    public List<Triaje> findTriaje() {
        return triajeRepository.findAll();
    }

    @Transactional
    public void deleteTriaje(Integer id) {
        triajeRepository.deleteById(id);
    }
}