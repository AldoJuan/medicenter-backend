package com.lvl.medicenter.dto.medicamento;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedicamentoRequest {
    private String nombre;
    private BigDecimal precioVenta;
    private Integer stockActual;
    private String presentacion;
    private String concentracion;
}