package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.pago.PagoRequest;
import com.lvl.medicenter.dto.pago.PagoResponse;
import com.lvl.medicenter.facade.PagoFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoFacade pagoFacade;

    @PostMapping
    public PagoResponse saveOrUpdate(@RequestBody PagoRequest request) {
        return pagoFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public PagoResponse getById(@PathVariable Integer id) {
        return pagoFacade.getById(id);
    }

    @GetMapping
    public List<PagoResponse> findByCuota(@RequestParam Integer cuotaId) {
        return pagoFacade.findByCuota(cuotaId);
    }
}
