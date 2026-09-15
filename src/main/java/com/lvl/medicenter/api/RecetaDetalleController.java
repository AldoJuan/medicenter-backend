package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.recetadetalle.RecetaDetalleRequest;
import com.lvl.medicenter.dto.recetadetalle.RecetaDetalleResponse;
import com.lvl.medicenter.facade.RecetaDetalleFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recetas-detalle")
@RequiredArgsConstructor
public class RecetaDetalleController {

    private final RecetaDetalleFacade recetaDetalleFacade;

    @PostMapping
    public RecetaDetalleResponse saveOrUpdate(@RequestBody RecetaDetalleRequest request) {
        return recetaDetalleFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public RecetaDetalleResponse getById(@PathVariable Integer id) {
        return recetaDetalleFacade.getById(id);
    }

    @GetMapping
    public List<RecetaDetalleResponse> findByAtencion(@RequestParam Integer atencionId) {
        return recetaDetalleFacade.findByAtencion(atencionId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        recetaDetalleFacade.delete(id);
    }
}
