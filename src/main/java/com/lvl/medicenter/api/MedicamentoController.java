package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.medicamento.MedicamentoRequest;
import com.lvl.medicenter.dto.medicamento.MedicamentoResponse;
import com.lvl.medicenter.facade.MedicamentoFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoFacade medicamentoFacade;

    @PostMapping
    public MedicamentoResponse saveOrUpdate(@RequestBody MedicamentoRequest request) {
        return medicamentoFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public MedicamentoResponse getById(@PathVariable Integer id) {
        return medicamentoFacade.getById(id);
    }

    @GetMapping
    public List<MedicamentoResponse> findAll() {
        return medicamentoFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        medicamentoFacade.delete(id);
    }
}