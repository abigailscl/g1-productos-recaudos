package com.banquito.core.recaudos.controller.mapper;

import com.banquito.core.recaudos.controller.dto.ProductoRecaudoRS;
import com.banquito.core.recaudos.model.ProductoRecaudo;

public class ProductoRecaudoMapper {

    public static ProductoRecaudoRS map(ProductoRecaudo productoRecaudo) {
        return ProductoRecaudoRS.builder()
                .temporalidad(productoRecaudo.getTemporalidad())
                .nombre(productoRecaudo.getNombre())
                .admiteComision(productoRecaudo.getAdmiteComision())
                .asumeComision(productoRecaudo.getAsumeComision())
                .estado(productoRecaudo.getEstado())
                .build();
    }

}
