package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Factura;
import com.lvl.medicenter.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaService {

    private final FacturaRepository facturaRepository;

    @Transactional
    public Factura saveOrUpdateFactura(Factura factura) {
        if (factura.getFacturaId() == null) {
            factura.setFechaEmision(LocalDateTime.now());
            factura.setEstado("EMITIDA");
        }
        return facturaRepository.save(factura);
    }

    public Factura getByIdFactura(Integer id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con id: " + id));
    }

    public List<Factura> findFactura() {
        return facturaRepository.findAll();
    }

    @Transactional
    public void deleteFactura(Integer id) {
        facturaRepository.deleteById(id);
    }
}