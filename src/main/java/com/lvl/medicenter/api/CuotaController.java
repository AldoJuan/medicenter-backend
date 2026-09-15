package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.cuota.CuotaRequest;
import com.lvl.medicenter.dto.cuota.CuotaResponse;
import com.lvl.medicenter.facade.CuotaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuotas")
@RequiredArgsConstructor
public class CuotaController {

    private final CuotaFacade cuotaFacade;

    @PostMapping
    public CuotaResponse saveOrUpdate(@RequestBody CuotaRequest request) {
        return cuotaFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public CuotaResponse getById(@PathVariable Integer id) {
        return cuotaFacade.getById(id);
    }

    @GetMapping
    public List<CuotaResponse> findByFactura(@RequestParam Integer facturaId) {
        return cuotaFacade.findByFactura(facturaId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cuotaFacade.delete(id);
    }
}
