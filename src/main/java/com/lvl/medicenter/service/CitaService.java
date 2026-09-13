package com.lvl.medicenter.service;


import com.lvl.medicenter.domain.Cita;
import com.lvl.medicenter.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;

    public Cita saveOrUpdateCita(Cita cita){
        validarDisponibilidadMedico(cita);

        if (cita.getCitaId() == null){
            cita.setEstado("RESERVADA");
            cita.setFechaReserva(LocalDateTime.now());
        }
        return citaRepository.save(cita);
    }

    private void validarDisponibilidadMedico(Cita cita) {
        List<Cita> citasDelMedico = citaRepository.findByMedicoIdAndFechaCitaAndEstadoNot(
                cita.getMedicoId(), cita.getFechaCita(), "CANCELADA");

        for (Cita citaExistente : citasDelMedico) {
            if (citaExistente.getCitaId().equals(cita.getCitaId())) {
                continue;
            }
            boolean seCruzan = cita.getHoraInicio().isBefore(citaExistente.getHoraFin())
                    && citaExistente.getHoraInicio().isBefore(cita.getHoraFin());
            if (seCruzan) {
                throw new RuntimeException("El médico ya tiene una cita programada en ese horario");
            }
        }
    }

    @Transactional
    public Cita activarCita(Integer citaId, BigDecimal montoAdelanto) {
        Cita cita = getByIdCita(citaId);
        cita.setMontoAdelanto(montoAdelanto);
        cita.setEstado("ACTIVADA");
        return citaRepository.save(cita);
    }

    public Cita getByIdCita(Integer id) {
        return citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));
    }

    public List<Cita> findCita() {
        return citaRepository.findAll();
    }

    @Transactional
    public void deleteCita(Integer id) {
        citaRepository.deleteById(id);
    }
}
