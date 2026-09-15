package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.triaje.TriajeRequest;
import com.lvl.medicenter.dto.triaje.TriajeResponse;
import com.lvl.medicenter.facade.TriajeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/triajes")
@RequiredArgsConstructor
public class TriajeController {

    private final TriajeFacade triajeFacade;

    @PostMapping
    public TriajeResponse saveOrUpdate(@RequestBody TriajeRequest request) {
        return triajeFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public TriajeResponse getById(@PathVariable Integer id) {
        return triajeFacade.getById(id);
    }

    @GetMapping
    public List<TriajeResponse> findAll() {
        return triajeFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        triajeFacade.delete(id);
    }
}