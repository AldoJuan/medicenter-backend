package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.AtencionMedica;
import com.lvl.medicenter.repository.AtencionMedicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtencionMedicaService {

    private final AtencionMedicaRepository atencionMedicaRepository;

    @Transactional
    public AtencionMedica saveOrUpdateAtencionMedica(AtencionMedica atencionMedica) {
        if (atencionMedica.getAtencionId() == null) {
            atencionMedica.setFechaHoraAtencion(LocalDateTime.now());
        }
        return atencionMedicaRepository.save(atencionMedica);
    }

    public AtencionMedica getByIdAtencionMedica(Integer id) {
        return atencionMedicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atención médica no encontrada con id: " + id));
    }

    public List<AtencionMedica> findAtencionMedica() {
        return atencionMedicaRepository.findAll();
    }

    @Transactional
    public void deleteAtencionMedica(Integer id) {
        atencionMedicaRepository.deleteById(id);
    }
}