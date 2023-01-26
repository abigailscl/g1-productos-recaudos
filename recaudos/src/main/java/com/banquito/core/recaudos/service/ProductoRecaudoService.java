package com.banquito.core.recaudos.service;

import org.springframework.stereotype.Service;

import com.banquito.core.recaudos.exception.CRUDException;
import com.banquito.core.recaudos.model.ProductoRecaudo;
import com.banquito.core.recaudos.repository.ProductoRecaudoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoRecaudoService {

    private final ProductoRecaudoRepository productoRecaudoRepository;

    public ProductoRecaudoService(ProductoRecaudoRepository productoRecaudoRepository) {
        this.productoRecaudoRepository = productoRecaudoRepository;
    }

    public ProductoRecaudo obtenerRecaudoNombre(String nombre) {
        log.info("Va a consultar el producto de recaudo con el nombre: {}", nombre);
        ProductoRecaudo recaudo = this.productoRecaudoRepository.findByNombre(nombre);
        log.debug("El producto de recaudo consultado es por el nombre {} -> {}", nombre, recaudo);
        return recaudo;
    }

    public ProductoRecaudo obtenerRecaudoCodigo(String codigo) {
        log.info("Va a consultar el producto de recaudo con el codigo: {}", codigo);
        ProductoRecaudo recaudo = this.productoRecaudoRepository.findByCodigoProductoRecaudo(codigo);
        log.debug("El producto de recaudo consultado es por el codigo {} -> {}", codigo, recaudo);
        return recaudo;
    }

    public void crearProductoRecaudo(ProductoRecaudo recaudo) throws CRUDException {
        log.info("Va a crear el producto de recaudo:");
        log.debug("Datos del recaudo a ser creado {}", recaudo);
        try {
            recaudo.setCodigoProductoRecaudo(this.generarCodigo(3));
            this.productoRecaudoRepository.save(recaudo);
        } catch (Exception e) {
            log.error("Error al crear el producto de recaudo: {}, con los datos: {}", e.getMessage(), recaudo);
            throw new CRUDException("No se pudo crear el producto de recaudo " + e.getMessage(), e);
        }
    }

    public void actualizarProductoRecaudo(ProductoRecaudo recaudo) throws CRUDException {
        log.info("Va a actualizar el producto de recaudo con la siguiete informacion: {}", recaudo);
        try {
            ProductoRecaudo recaudoTemp = this.productoRecaudoRepository
                    .findByCodigoProductoRecaudo(recaudo.getCodigoProductoRecaudo());
            if (recaudoTemp == null) {
                throw new CRUDException(
                        "No se encontro el producto de recaudo con el codigo: " + recaudo.getCodigoProductoRecaudo());
            }
            recaudoTemp.setCodigoProductoRecaudo(recaudo.getCodigoProductoRecaudo());
            recaudoTemp.setNombre(recaudo.getNombre());
            recaudoTemp.setTemporalidad(recaudo.getTemporalidad());
            recaudoTemp.setAdmiteComision(recaudo.getAdmiteComision());
            recaudoTemp.setAsumeComision(recaudo.getAsumeComision());
            recaudoTemp.setEstado(recaudo.getEstado());
            this.productoRecaudoRepository.save(recaudoTemp);
        } catch (Exception e) {
            log.error("Error al actualizar el producto de recaudo: {}, con los datos: {}", e.getMessage(), recaudo);
            throw new CRUDException("No se pudo actualizar el producto de recaudo " + e.getMessage(), e);
        }
    }

    public String generarCodigo(int longitud) {
        String codigo = "";
        for (int i = 0; i < longitud; i++) {
            codigo += (int) (Math.random() * 10);
        }
        return codigo;
    }
}