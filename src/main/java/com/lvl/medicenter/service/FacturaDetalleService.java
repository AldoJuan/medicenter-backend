package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.FacturaDetalle;
import com.lvl.medicenter.repository.FacturaDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaDetalleService {

    private final FacturaDetalleRepository facturaDetalleRepository;

    @Transactional
    public FacturaDetalle saveOrUpdateFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleRepository.save(facturaDetalle);
    }

    public FacturaDetalle getByIdFacturaDetalle(Integer id) {
        return facturaDetalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de factura no encontrado con id: " + id));
    }

    public List<FacturaDetalle> findFacturaDetalle(Integer facturaId) {
        return facturaDetalleRepository.findByFacturaId(facturaId);
    }

    @Transactional
    public void deleteFacturaDetalle(Integer id) {
        facturaDetalleRepository.deleteById(id);
    }
}