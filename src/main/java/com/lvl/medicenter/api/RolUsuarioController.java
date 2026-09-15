package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.rolusuario.RolUsuarioRequest;
import com.lvl.medicenter.dto.rolusuario.RolUsuarioResponse;
import com.lvl.medicenter.facade.RolUsuarioFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles-usuarios")
@RequiredArgsConstructor
public class RolUsuarioController {

    private final RolUsuarioFacade rolUsuarioFacade;

    @PostMapping
    public RolUsuarioResponse saveOrUpdate(@RequestBody RolUsuarioRequest request) {
        return rolUsuarioFacade.saveOrUpdate(request);
    }

    @GetMapping
    public List<RolUsuarioResponse> findAll() {
        return rolUsuarioFacade.findAll();
    }

    @DeleteMapping("/{rolId}/{usuarioId}")
    public void delete(@PathVariable Integer rolId, @PathVariable Integer usuarioId) {
        rolUsuarioFacade.delete(rolId, usuarioId);
    }
}