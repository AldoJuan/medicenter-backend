package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.reporte.AtencionesPorEspecialidadResponse;
import com.lvl.medicenter.dto.reporte.AtencionesPorMedicoResponse;
import com.lvl.medicenter.dto.reporte.CierreCajaResponse;
import com.lvl.medicenter.dto.reporte.VentasPorComprobanteResponse;
import com.lvl.medicenter.facade.ReporteFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteFacade reporteFacade;

    @GetMapping("/atenciones-por-medico")
    public List<AtencionesPorMedicoResponse> atencionesPorMedico() {
        return reporteFacade.atencionesPorMedico();
    }

    @GetMapping("/ranking-medicos")
    public List<AtencionesPorMedicoResponse> rankingMedicos(@RequestParam(defaultValue = "10") int limite) {
        return reporteFacade.rankingMedicos(limite);
    }

    @GetMapping("/ranking-especialidades")
    public List<AtencionesPorEspecialidadResponse> rankingEspecialidades() {
        return reporteFacade.rankingEspecialidades();
    }

    @GetMapping("/ventas-por-comprobante")
    public List<VentasPorComprobanteResponse> ventasPorComprobante(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return reporteFacade.ventasPorComprobante(desde, hasta);
    }

    @GetMapping("/cierre-caja")
    public List<CierreCajaResponse> cierreCaja(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return reporteFacade.cierreCaja(desde, hasta);
    }
}
