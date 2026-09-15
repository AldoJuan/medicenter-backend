package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.horariomedico.HorarioMedicoRequest;
import com.lvl.medicenter.dto.horariomedico.HorarioMedicoResponse;
import com.lvl.medicenter.facade.HorarioMedicoFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios-medicos")
@RequiredArgsConstructor
public class HorarioMedicoController {

    private final HorarioMedicoFacade horarioMedicoFacade;

    @PostMapping
    public HorarioMedicoResponse saveOrUpdate(@RequestBody HorarioMedicoRequest request) {
        return horarioMedicoFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public HorarioMedicoResponse getById(@PathVariable Integer id) {
        return horarioMedicoFacade.getById(id);
    }

    @GetMapping
    public List<HorarioMedicoResponse> findAll() {
        return horarioMedicoFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        horarioMedicoFacade.delete(id);
    }
}