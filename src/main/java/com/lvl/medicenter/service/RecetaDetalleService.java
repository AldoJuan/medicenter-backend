package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Medicamento;
import com.lvl.medicenter.domain.RecetaDetalle;
import com.lvl.medicenter.repository.MedicamentoRepository;
import com.lvl.medicenter.repository.RecetaDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecetaDetalleService {

    private final RecetaDetalleRepository recetaDetalleRepository;
    private final MedicamentoRepository medicamentoRepository;

    @Transactional
    public RecetaDetalle saveOrUpdateRecetaDetalle(RecetaDetalle recetaDetalle) {
        medicamentoRepository.findById(recetaDetalle.getMedicamentoId())
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado con id: " + recetaDetalle.getMedicamentoId()));
        return recetaDetalleRepository.save(recetaDetalle);
    }

    public RecetaDetalle getByIdRecetaDetalle(Integer id) {
        return recetaDetalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de receta no encontrado con id: " + id));
    }

    public List<RecetaDetalle> findByAtencionRecetaDetalle(Integer atencionId) {
        return recetaDetalleRepository.findByAtencionId(atencionId);
    }

    @Transactional
    public void deleteRecetaDetalle(Integer id) {
        recetaDetalleRepository.deleteById(id);
    }
}