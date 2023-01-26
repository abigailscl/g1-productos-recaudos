package com.banquito.core.recaudos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "recaudos")
public class ProductoRecaudo {

    @Id
    private String id;

    private String codigoProductoRecaudo;
    private String nombre;
    private String temporalidad;
    private String admiteComision;
    private String asumeComision;
    private String estado;

    @Version
    private Long version;


        
}
