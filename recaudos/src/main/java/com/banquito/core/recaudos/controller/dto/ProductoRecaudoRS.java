package com.banquito.core.recaudos.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoRecaudoRS implements Serializable{

    private String nombre;
    private String temporalidad;
    private String admiteComision;
    private String asumeComision;
    private String estado;
    
}
