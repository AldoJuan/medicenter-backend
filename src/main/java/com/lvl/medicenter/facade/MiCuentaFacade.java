package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Cita;
import com.lvl.medicenter.domain.Cuota;
import com.lvl.medicenter.domain.RecetaDetalle;
import com.lvl.medicenter.dto.cita.CitaResponse;
import com.lvl.medicenter.dto.cuota.CuotaResponse;
import com.lvl.medicenter.dto.recetadetalle.RecetaDetalleResponse;
import com.lvl.medicenter.service.MiCuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MiCuentaFacade {

    private final MiCuentaService miCuentaService;

    public List<CitaResponse> misCitas(Integer pacienteId) {
        return miCuentaService.misCitas(pacienteId).stream().map(this::toResponse).toList();
    }

    public List<CuotaResponse> misSaldos(Integer pacienteId) {
        return miCuentaService.misSaldos(pacienteId).stream().map(this::toResponse).toList();
    }

    public List<RecetaDetalleResponse> misRecetas(Integer pacienteId) {
        return miCuentaService.misRecetas(pacienteId).stream().map(this::toResponse).toList();
    }

    private CitaResponse toResponse(Cita cita) {
        CitaResponse response = new CitaResponse();
        response.setCitaId(cita.getCitaId());
        response.setPacienteId(cita.getPacienteId());
        response.setMedicoId(cita.getMedicoId());
        response.setFechaCita(cita.getFechaCita());
        response.setHoraInicio(cita.getHoraInicio());
        response.setHoraFin(cita.getHoraFin());
        response.setEstado(cita.getEstado());
        response.setMontoAdelanto(cita.getMontoAdelanto());
        response.setFechaReserva(cita.getFechaReserva());
        response.setObservaciones(cita.getObservaciones());
        return response;
    }

    private CuotaResponse toResponse(Cuota cuota) {
        CuotaResponse response = new CuotaResponse();
        response.setCuotaId(cuota.getCuotaId());
        response.setFacturaId(cuota.getFacturaId());
        response.setNumeroCuota(cuota.getNumeroCuota());
        response.setMonto(cuota.getMonto());
        response.setFechaVencimiento(cuota.getFechaVencimiento());
        response.setEstado(cuota.getEstado());
        return response;
    }

    private RecetaDetalleResponse toResponse(RecetaDetalle receta) {
        RecetaDetalleResponse response = new RecetaDetalleResponse();
        response.setRecetaDetalleId(receta.getRecetaDetalleId());
        response.setAtencionId(receta.getAtencionId());
        response.setMedicamentoId(receta.getMedicamentoId());
        response.setDosis(receta.getDosis());
        response.setDuracionTratamiento(receta.getDuracionTratamiento());
        response.setIndicaciones(receta.getIndicaciones());
        return response;
    }
}
