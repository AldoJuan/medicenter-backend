package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.factura.FacturaRequest;
import com.lvl.medicenter.dto.factura.FacturaResponse;
import com.lvl.medicenter.facade.FacturaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaFacade facturaFacade;

    @PostMapping
    public FacturaResponse saveOrUpdate(@RequestBody FacturaRequest request) {
        return facturaFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public FacturaResponse getById(@PathVariable Integer id) {
        return facturaFacade.getById(id);
    }

    @GetMapping
    public List<FacturaResponse> findAll() {
        return facturaFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        facturaFacade.delete(id);
    }
}
