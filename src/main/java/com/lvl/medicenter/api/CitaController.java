package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.cita.ActivarCitaRequest;
import com.lvl.medicenter.dto.cita.CitaRequest;
import com.lvl.medicenter.dto.cita.CitaResponse;
import com.lvl.medicenter.facade.CitaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaFacade citaFacade;

    @PostMapping
    public CitaResponse saveOrUpdate(@RequestBody CitaRequest request) {
        return citaFacade.saveOrUpdate(request);
    }

    @PatchMapping("/{id}/activar")
    public CitaResponse activar(@PathVariable Integer id, @RequestBody ActivarCitaRequest request) {
        return citaFacade.activar(id, request.getMontoAdelanto());
    }

    @GetMapping("/{id}")
    public CitaResponse getById(@PathVariable Integer id) {
        return citaFacade.getById(id);
    }

    @GetMapping
    public List<CitaResponse> findAll() {
        return citaFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        citaFacade.delete(id);
    }
}