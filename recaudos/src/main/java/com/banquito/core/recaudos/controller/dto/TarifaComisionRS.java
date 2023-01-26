package com.banquito.core.recaudos.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarifaComisionRS implements Serializable {

    private String tipoServicio;
    private BigDecimal valor;
    private String estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

}
