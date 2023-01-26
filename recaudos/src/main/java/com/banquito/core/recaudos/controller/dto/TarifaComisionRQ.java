package com.banquito.core.recaudos.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarifaComisionRQ implements Serializable {

    private String codigoTarifaComision;
    private String tipoServicio;
    private String valor;
    private String estado;
    private String fechaInicio;
    private String fechaFin;

}
