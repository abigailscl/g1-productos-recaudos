package com.banquito.core.recaudos.controller.mapper;

import com.banquito.core.recaudos.controller.dto.TarifaComisionRS;
import com.banquito.core.recaudos.model.TarifaComision;

public class TarifaComisionMapper {

    public static TarifaComisionRS map(TarifaComision tarifaComision) {
        return TarifaComisionRS.builder()
                .estado(tarifaComision.getEstado())
                .tipoServicio(tarifaComision.getTipoServicio())
                .valor(tarifaComision.getValor())
                .fechaFin(tarifaComision.getFechaFin())
                .fechaInicio(tarifaComision.getFechaInicio())
                .build();
    }

}
