package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.medico.MedicoRequest;
import com.lvl.medicenter.dto.medico.MedicoResponse;
import com.lvl.medicenter.facade.MedicoFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoFacade medicoFacade;

    @PostMapping
    public MedicoResponse saveOrUpdate(@RequestBody MedicoRequest request) {
        return medicoFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public MedicoResponse getById(@PathVariable Integer id) {
        return medicoFacade.getById(id);
    }

    @GetMapping
    public List<MedicoResponse> findAll() {
        return medicoFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        medicoFacade.delete(id);
    }
}