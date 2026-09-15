package com.lvl.medicenter.facade;

import com.lvl.medicenter.domain.Medicamento;
import com.lvl.medicenter.dto.medicamento.MedicamentoRequest;
import com.lvl.medicenter.dto.medicamento.MedicamentoResponse;
import com.lvl.medicenter.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MedicamentoFacade {

    private final MedicamentoService medicamentoService;

    public MedicamentoResponse saveOrUpdate(MedicamentoRequest request) {
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre(request.getNombre());
        medicamento.setPrecioVenta(request.getPrecioVenta());
        medicamento.setStockActual(request.getStockActual());
        medicamento.setPresentacion(request.getPresentacion());
        medicamento.setConcentracion(request.getConcentracion());
        return toResponse(medicamentoService.saveOrUpdateMedicamento(medicamento));
    }

    public MedicamentoResponse getById(Integer id) {
        return toResponse(medicamentoService.getByIdMedicamento(id));
    }

    public List<MedicamentoResponse> findAll() {
        return medicamentoService.findMedicamento().stream().map(this::toResponse).toList();
    }

    public void delete(Integer id) {
        medicamentoService.deleteMedicamento(id);
    }

    private MedicamentoResponse toResponse(Medicamento medicamento) {
        MedicamentoResponse response = new MedicamentoResponse();
        response.setMedicamentoId(medicamento.getMedicamentoId());
        response.setNombre(medicamento.getNombre());
        response.setPrecioVenta(medicamento.getPrecioVenta());
        response.setStockActual(medicamento.getStockActual());
        response.setPresentacion(medicamento.getPresentacion());
        response.setConcentracion(medicamento.getConcentracion());
        return response;
    }
}