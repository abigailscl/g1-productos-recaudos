package com.banquito.core.recaudos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.core.recaudos.model.ProductoRecaudo;

public interface ProductoRecaudoRepository extends MongoRepository<ProductoRecaudo, String> {
    ProductoRecaudo findByNombre(String nombre);
    ProductoRecaudo findByTemporalidad(String temporalidad);
    ProductoRecaudo findByCodigoProductoRecaudo(String codigoProductoRecaudo);
    
}
