package com.lvl.medicenter.facade;

import com.lvl.medicenter.dto.reporte.AtencionesPorEspecialidadResponse;
import com.lvl.medicenter.dto.reporte.AtencionesPorMedicoResponse;
import com.lvl.medicenter.dto.reporte.CierreCajaResponse;
import com.lvl.medicenter.dto.reporte.VentasPorComprobanteResponse;
import com.lvl.medicenter.repository.projection.AtencionesPorEspecialidadProjection;
import com.lvl.medicenter.repository.projection.AtencionesPorMedicoProjection;
import com.lvl.medicenter.repository.projection.CierreCajaProjection;
import com.lvl.medicenter.repository.projection.VentasPorComprobanteProjection;
import com.lvl.medicenter.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReporteFacade {

    private final ReporteService reporteService;

    public List<AtencionesPorMedicoResponse> atencionesPorMedico() {
        return reporteService.atencionesPorMedico().stream().map(this::toResponse).toList();
    }

    public List<AtencionesPorMedicoResponse> rankingMedicos(int limite) {
        return reporteService.rankingMedicos(limite).stream().map(this::toResponse).toList();
    }

    public List<AtencionesPorEspecialidadResponse> rankingEspecialidades() {
        return reporteService.rankingEspecialidades().stream().map(this::toResponse).toList();
    }

    public List<VentasPorComprobanteResponse> ventasPorComprobante(LocalDate desde, LocalDate hasta) {
        LocalDateTime inicio = desde.atStartOfDay();
        LocalDateTime fin = hasta.plusDays(1).atStartOfDay();
        return reporteService.ventasPorComprobante(inicio, fin).stream().map(this::toResponse).toList();
    }

    public List<CierreCajaResponse> cierreCaja(LocalDate desde, LocalDate hasta) {
        LocalDateTime inicio = desde.atStartOfDay();
        LocalDateTime fin = hasta.plusDays(1).atStartOfDay();
        return reporteService.cierreCaja(inicio, fin).stream().map(this::toResponse).toList();
    }

    private AtencionesPorMedicoResponse toResponse(AtencionesPorMedicoProjection p) {
        AtencionesPorMedicoResponse response = new AtencionesPorMedicoResponse();
        response.setMedicoId(p.getMedicoId());
        response.setNombreMedico(p.getNombreMedico());
        response.setCantidadAtenciones(p.getCantidadAtenciones());
        return response;
    }

    private AtencionesPorEspecialidadResponse toResponse(AtencionesPorEspecialidadProjection p) {
        AtencionesPorEspecialidadResponse response = new AtencionesPorEspecialidadResponse();
        response.setEspecialidadId(p.getEspecialidadId());
        response.setNombreEspecialidad(p.getNombreEspecialidad());
        response.setCantidadAtenciones(p.getCantidadAtenciones());
        return response;
    }

    private VentasPorComprobanteResponse toResponse(VentasPorComprobanteProjection p) {
        VentasPorComprobanteResponse response = new VentasPorComprobanteResponse();
        response.setTipoComprobante(p.getTipoComprobante());
        response.setCantidad(p.getCantidad());
        response.setMontoTotal(p.getMontoTotal());
        return response;
    }

    private CierreCajaResponse toResponse(CierreCajaProjection p) {
        CierreCajaResponse response = new CierreCajaResponse();
        response.setMoneda(p.getMoneda());
        response.setFormaPago(p.getFormaPago());
        response.setMedioPago(p.getMedioPago());
        response.setCantidadComprobantes(p.getCantidadComprobantes());
        response.setMontoTotal(p.getMontoTotal());
        return response;
    }
}
