package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.facturadetalle.FacturaDetalleRequest;
import com.lvl.medicenter.dto.facturadetalle.FacturaDetalleResponse;
import com.lvl.medicenter.facade.FacturaDetalleFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas-detalle")
@RequiredArgsConstructor
public class FacturaDetalleController {

    private final FacturaDetalleFacade facturaDetalleFacade;

    @PostMapping
    public FacturaDetalleResponse saveOrUpdate(@RequestBody FacturaDetalleRequest request) {
        return facturaDetalleFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public FacturaDetalleResponse getById(@PathVariable Integer id) {
        return facturaDetalleFacade.getById(id);
    }

    @GetMapping
    public List<FacturaDetalleResponse> findByFactura(@RequestParam Integer facturaId) {
        return facturaDetalleFacade.findByFactura(facturaId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        facturaDetalleFacade.delete(id);
    }
}
