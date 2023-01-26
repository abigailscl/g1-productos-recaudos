package com.banquito.core.recaudos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.core.recaudos.model.TarifaComision;

public interface TarifaComisionRepository extends MongoRepository<TarifaComision, String> {
    TarifaComision findByCodigoTarifaComision(String codigoTarifaComision);
    TarifaComision findByTipoServicio(String tipoServicio);
    TarifaComision findByEstado(String estado);

}
