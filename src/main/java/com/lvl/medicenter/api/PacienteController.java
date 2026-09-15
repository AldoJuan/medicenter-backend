package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.paciente.PacienteRequest;
import com.lvl.medicenter.dto.paciente.PacienteResponse;
import com.lvl.medicenter.facade.PacienteFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteFacade pacienteFacade;

    @PostMapping
    public PacienteResponse saveOrUpdate(@RequestBody PacienteRequest request) {
        return pacienteFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public PacienteResponse getById(@PathVariable Integer id) {
        return pacienteFacade.getById(id);
    }

    @GetMapping
    public List<PacienteResponse> findAll() {
        return pacienteFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pacienteFacade.delete(id);
    }
}