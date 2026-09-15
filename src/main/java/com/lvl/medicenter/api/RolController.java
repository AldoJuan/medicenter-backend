package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.rol.RolRequest;
import com.lvl.medicenter.dto.rol.RolResponse;
import com.lvl.medicenter.facade.RolFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolFacade rolFacade;

    @PostMapping
    public RolResponse saveOrUpdate(@RequestBody RolRequest request) {
        return rolFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public RolResponse getById(@PathVariable Integer id) {
        return rolFacade.getById(id);
    }

    @GetMapping
    public List<RolResponse> findAll() {
        return rolFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        rolFacade.delete(id);
    }
}