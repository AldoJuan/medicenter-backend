package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.atencionmedica.AtencionMedicaRequest;
import com.lvl.medicenter.dto.atencionmedica.AtencionMedicaResponse;
import com.lvl.medicenter.facade.AtencionMedicaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atenciones-medicas")
@RequiredArgsConstructor
public class AtencionMedicaController {

    private final AtencionMedicaFacade atencionMedicaFacade;

    @PostMapping
    public AtencionMedicaResponse saveOrUpdate(@RequestBody AtencionMedicaRequest request) {
        return atencionMedicaFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public AtencionMedicaResponse getById(@PathVariable Integer id) {
        return atencionMedicaFacade.getById(id);
    }

    @GetMapping
    public List<AtencionMedicaResponse> findAll() {
        return atencionMedicaFacade.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        atencionMedicaFacade.delete(id);
    }
}