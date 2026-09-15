package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.FacturaDetalle;
import com.lvl.medicenter.dto.facturadetalle.FacturaDetalleRequest;
import com.lvl.medicenter.dto.facturadetalle.FacturaDetalleResponse;
import com.lvl.medicenter.service.FacturaDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FacturaDetalleFacade {

    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleResponse saveOrUpdate(FacturaDetalleRequest request) {
        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setFacturaId(request.getFacturaId());
        detalle.setMedicamentoId(request.getMedicamentoId());
        detalle.setTipoItem(request.getTipoItem());
        detalle.setDescripcion(request.getDescripcion());
        detalle.setCantidad(request.getCantidad());
        detalle.setPrecioUnitario(request.getPrecioUnitario());
        detalle.setSubtotal(request.getSubtotal());
        return toResponse(facturaDetalleService.saveOrUpdateFacturaDetalle(detalle));
    }

    public FacturaDetalleResponse getById(Integer id) {
        return toResponse(facturaDetalleService.getByIdFacturaDetalle(id));
    }

    public List<FacturaDetalleResponse> findByFactura(Integer facturaId) {
        return facturaDetalleService.findFacturaDetalle(facturaId).stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        facturaDetalleService.deleteFacturaDetalle(id);
    }

    private FacturaDetalleResponse toResponse(FacturaDetalle detalle) {
        FacturaDetalleResponse response = new FacturaDetalleResponse();
        response.setFacturaDetalleId(detalle.getFacturaDetalleId());
        response.setFacturaId(detalle.getFacturaId());
        response.setMedicamentoId(detalle.getMedicamentoId());
        response.setTipoItem(detalle.getTipoItem());
        response.setDescripcion(detalle.getDescripcion());
        response.setCantidad(detalle.getCantidad());
        response.setPrecioUnitario(detalle.getPrecioUnitario());
        response.setSubtotal(detalle.getSubtotal());
        return response;
    }
}
