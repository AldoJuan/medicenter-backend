package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Cuota;
import com.lvl.medicenter.domain.Pago;
import com.lvl.medicenter.repository.CuotaRepository;
import com.lvl.medicenter.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;
    private final CuotaRepository cuotaRepository;

    @Transactional
    public Pago saveOrUpdatePago(Pago pago) {
        Cuota cuota = cuotaRepository.findById(pago.getCuotaId())
                .orElseThrow(() -> new RuntimeException("Cuota no encontrada con id: " + pago.getCuotaId()));

        if (pago.getPagoId() == null) {
            pago.setFechaPago(LocalDateTime.now());
        }

        Pago pagoGuardado = pagoRepository.save(pago);

        BigDecimal totalPagado = pagoRepository.findByCuotaId(cuota.getCuotaId()).stream()
                .map(Pago::getMontoPagado)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalPagado.compareTo(cuota.getMonto()) >= 0) {
            cuota.setEstado("PAGADA");
            cuotaRepository.save(cuota);
        }

        return pagoGuardado;
    }

    public Pago getByIdPago(Integer id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con id: " + id));
    }

    public List<Pago> findPago(Integer cuotaId) {
        return pagoRepository.findByCuotaId(cuotaId);
    }
}