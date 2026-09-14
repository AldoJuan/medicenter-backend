package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.usuario.UsuarioRequest;
import com.lvl.medicenter.dto.usuario.UsuarioResponse;
import com.lvl.medicenter.facade.UsuarioFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    @PostMapping
    public UsuarioResponse saveOrUpdate(@RequestBody UsuarioRequest request) {
        return usuarioFacade.saveOrUpdate(request);
    }

    @GetMapping("/{id}")
    public UsuarioResponse getById(@PathVariable Integer id) {
        return usuarioFacade.getById(id);
    }
}