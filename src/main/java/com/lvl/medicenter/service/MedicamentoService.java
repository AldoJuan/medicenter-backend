package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Medicamento;
import com.lvl.medicenter.repository.MedicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    @Transactional
    public Medicamento saveOrUpdateMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento getByIdMedicamento(Integer id) {
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado con id: " + id));
    }

    public List<Medicamento> findMedicamento() {
        return medicamentoRepository.findAll();
    }

    @Transactional
    public void deleteMedicamento(Integer id) {
        medicamentoRepository.deleteById(id);
    }
}