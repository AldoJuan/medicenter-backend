package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.especialidad.EspecialidadRequest;
import com.lvl.medicenter.dto.especialidad.EspecialidadResponse;
import com.lvl.medicenter.facade.EspecialidadFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final EspecialidadFacade especialidadFacade;

    @PostMapping
    public EspecialidadResponse saveOrUpdate(@RequestBody EspecialidadRequest request) {
        return especialidadFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public EspecialidadResponse getById(@PathVariable Integer id) {
        return especialidadFacade.getById(id);
    }

    @GetMapping
    public List<EspecialidadResponse> findAll() {
        return especialidadFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        especialidadFacade.delete(id);
    }
}