package com.banquito.core.recaudos.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarifaComisionRS implements Serializable {

    private String tipoServicio;
    private String valor;
    private String estado;
    private String fechaInicio;
    private String fechaFin;

}
