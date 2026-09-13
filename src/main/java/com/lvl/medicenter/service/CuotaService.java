package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Cuota;
import com.lvl.medicenter.repository.CuotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuotaService {

    private final CuotaRepository cuotaRepository;

    @Transactional
    public Cuota saveOrUpdateCuota(Cuota cuota) {
        return cuotaRepository.save(cuota);
    }

    public Cuota getByIdCuota(Integer id) {
        return cuotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuota no encontrada con id: " + id));
    }

    public List<Cuota> findCuota(Integer facturaId) {
        return cuotaRepository.findByFacturaId(facturaId);
    }

    @Transactional
    public void deleteCuota(Integer id) {
        cuotaRepository.deleteById(id);
    }
}