package com.lvl.medicenter.service;

import com.lvl.medicenter.repository.AtencionMedicaRepository;
import com.lvl.medicenter.repository.FacturaRepository;
import com.lvl.medicenter.repository.projection.AtencionesPorEspecialidadProjection;
import com.lvl.medicenter.repository.projection.AtencionesPorMedicoProjection;
import com.lvl.medicenter.repository.projection.CierreCajaProjection;
import com.lvl.medicenter.repository.projection.VentasPorComprobanteProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final AtencionMedicaRepository atencionMedicaRepository;
    private final FacturaRepository facturaRepository;

    public List<AtencionesPorMedicoProjection> atencionesPorMedico() {
        return atencionMedicaRepository.countAtencionesPorMedico();
    }

    public List<AtencionesPorMedicoProjection> rankingMedicos(int limite) {
        return atencionMedicaRepository.rankingMedicosPorAtenciones(limite);
    }

    public List<AtencionesPorEspecialidadProjection> rankingEspecialidades() {
        return atencionMedicaRepository.rankingEspecialidadesPorAtenciones();
    }

    public List<VentasPorComprobanteProjection> ventasPorComprobante(LocalDateTime desde, LocalDateTime hasta) {
        return facturaRepository.ventasPorComprobante(desde, hasta);
    }

    public List<CierreCajaProjection> cierreCaja(LocalDateTime desde, LocalDateTime hasta) {
        return facturaRepository.cierreCaja(desde, hasta);
    }
}
