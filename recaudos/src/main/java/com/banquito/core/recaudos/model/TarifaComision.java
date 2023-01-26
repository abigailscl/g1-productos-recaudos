package com.banquito.core.recaudos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "tarifas")
public class TarifaComision {

    @Id
    private String id;

    private String codigoTarifaComision;

    private String tipoServicio;
    private BigDecimal valor;
    private String estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    @Version
    private Long version;

}
