package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Cita;
import com.lvl.medicenter.domain.Cuota;
import com.lvl.medicenter.domain.RecetaDetalle;
import com.lvl.medicenter.repository.CitaRepository;
import com.lvl.medicenter.repository.CuotaRepository;
import com.lvl.medicenter.repository.RecetaDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiCuentaService {

    private final CitaRepository citaRepository;
    private final CuotaRepository cuotaRepository;
    private final RecetaDetalleRepository recetaDetalleRepository;

    public List<Cita> misCitas(Integer pacienteId) {
        return citaRepository.findByPacienteId(pacienteId);
    }

    public List<Cuota> misSaldos(Integer pacienteId) {
        return cuotaRepository.findSaldosPendientesPorPaciente(pacienteId);
    }

    public List<RecetaDetalle> misRecetas(Integer pacienteId) {
        return recetaDetalleRepository.findByPacienteId(pacienteId);
    }
}
