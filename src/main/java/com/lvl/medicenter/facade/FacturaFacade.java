package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Factura;
import com.lvl.medicenter.dto.factura.FacturaRequest;
import com.lvl.medicenter.dto.factura.FacturaResponse;
import com.lvl.medicenter.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FacturaFacade {

    private final FacturaService facturaService;

    public FacturaResponse saveOrUpdate(FacturaRequest request) {
        Factura factura = new Factura();
        factura.setPacienteId(request.getPacienteId());
        factura.setCitaId(request.getCitaId());
        factura.setUsuarioEmisorId(request.getUsuarioEmisorId());
        factura.setTipoComprobante(request.getTipoComprobante());
        factura.setSerie(request.getSerie());
        factura.setNumero(request.getNumero());
        factura.setMoneda(request.getMoneda());
        factura.setFormaPago(request.getFormaPago());
        factura.setMedioPago(request.getMedioPago());
        factura.setSubtotal(request.getSubtotal());
        factura.setIgv(request.getIgv());
        factura.setTotal(request.getTotal());
        return toResponse(facturaService.saveOrUpdateFactura(factura));
    }

    public FacturaResponse getById(Integer id) {
        return toResponse(facturaService.getByIdFactura(id));
    }

    public List<FacturaResponse> findAll() {
        return facturaService.findFactura().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        facturaService.deleteFactura(id);
    }

    private FacturaResponse toResponse(Factura factura) {
        FacturaResponse response = new FacturaResponse();
        response.setFacturaId(factura.getFacturaId());
        response.setPacienteId(factura.getPacienteId());
        response.setCitaId(factura.getCitaId());
        response.setUsuarioEmisorId(factura.getUsuarioEmisorId());
        response.setTipoComprobante(factura.getTipoComprobante());
        response.setSerie(factura.getSerie());
        response.setNumero(factura.getNumero());
        response.setFechaEmision(factura.getFechaEmision());
        response.setMoneda(factura.getMoneda());
        response.setFormaPago(factura.getFormaPago());
        response.setMedioPago(factura.getMedioPago());
        response.setSubtotal(factura.getSubtotal());
        response.setIgv(factura.getIgv());
        response.setTotal(factura.getTotal());
        response.setEstado(factura.getEstado());
        return response;
    }
}
