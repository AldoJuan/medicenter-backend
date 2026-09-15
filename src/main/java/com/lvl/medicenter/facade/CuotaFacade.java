package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Cuota;
import com.lvl.medicenter.dto.cuota.CuotaRequest;
import com.lvl.medicenter.dto.cuota.CuotaResponse;
import com.lvl.medicenter.service.CuotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CuotaFacade {

    private final CuotaService cuotaService;

    public CuotaResponse saveOrUpdate(CuotaRequest request) {
        Cuota cuota = new Cuota();
        cuota.setFacturaId(request.getFacturaId());
        cuota.setNumeroCuota(request.getNumeroCuota());
        cuota.setMonto(request.getMonto());
        cuota.setFechaVencimiento(request.getFechaVencimiento());
        // El estado lo controla el sistema, no quien registra la cuota
        cuota.setEstado("PENDIENTE");
        return toResponse(cuotaService.saveOrUpdateCuota(cuota));
    }

    public CuotaResponse getById(Integer id) {
        return toResponse(cuotaService.getByIdCuota(id));
    }

    public List<CuotaResponse> findByFactura(Integer facturaId) {
        return cuotaService.findCuota(facturaId).stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        cuotaService.deleteCuota(id);
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
}
