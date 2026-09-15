package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.cita.CitaResponse;
import com.lvl.medicenter.dto.cuota.CuotaResponse;
import com.lvl.medicenter.dto.recetadetalle.RecetaDetalleResponse;
import com.lvl.medicenter.facade.MiCuentaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes/{pacienteId}")
@RequiredArgsConstructor
public class MiCuentaController {

    private final MiCuentaFacade miCuentaFacade;

    @GetMapping("/citas")
    public List<CitaResponse> misCitas(@PathVariable Integer pacienteId) {
        return miCuentaFacade.misCitas(pacienteId);
    }

    @GetMapping("/saldos")
    public List<CuotaResponse> misSaldos(@PathVariable Integer pacienteId) {
        return miCuentaFacade.misSaldos(pacienteId);
    }

    @GetMapping("/recetas")
    public List<RecetaDetalleResponse> misRecetas(@PathVariable Integer pacienteId) {
        return miCuentaFacade.misRecetas(pacienteId);
    }
}
