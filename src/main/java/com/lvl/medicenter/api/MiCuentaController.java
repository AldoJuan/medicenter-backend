package com.lvl.medicenter.api;

import com.lvl.medicenter.dto.cita.CitaResponse;
import com.lvl.medicenter.dto.cuota.CuotaResponse;
import com.lvl.medicenter.dto.recetadetalle.RecetaDetalleResponse;
import com.lvl.medicenter.facade.MiCuentaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Nota: estos endpoints asumen que el frontend ya sabe el pacienteId
// del usuario logueado (vendría del token en un login real). Sin
// autenticación implementada todavía, cualquiera podría pedir el
// pacienteId de otro — es una limitación conocida a documentar en
// el resumen técnico, no un descuido.
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
