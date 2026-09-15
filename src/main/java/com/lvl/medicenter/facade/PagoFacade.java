package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Pago;
import com.lvl.medicenter.dto.pago.PagoRequest;
import com.lvl.medicenter.dto.pago.PagoResponse;
import com.lvl.medicenter.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PagoFacade {

    private final PagoService pagoService;

    public PagoResponse saveOrUpdate(PagoRequest request) {
        Pago pago = new Pago();
        pago.setCuotaId(request.getCuotaId());
        pago.setMontoPagado(request.getMontoPagado());
        pago.setMedioPago(request.getMedioPago());
        pago.setUsuarioCobradorId(request.getUsuarioCobradorId());
        return toResponse(pagoService.saveOrUpdatePago(pago));
    }

    public PagoResponse getById(Integer id) {
        return toResponse(pagoService.getByIdPago(id));
    }

    public List<PagoResponse> findByCuota(Integer cuotaId) {
        return pagoService.findPago(cuotaId).stream().map(this::toResponse).toList();
    }

    private PagoResponse toResponse(Pago pago) {
        PagoResponse response = new PagoResponse();
        response.setPagoId(pago.getPagoId());
        response.setCuotaId(pago.getCuotaId());
        response.setFechaPago(pago.getFechaPago());
        response.setMontoPagado(pago.getMontoPagado());
        response.setMedioPago(pago.getMedioPago());
        response.setUsuarioCobradorId(pago.getUsuarioCobradorId());
        return response;
    }
}
