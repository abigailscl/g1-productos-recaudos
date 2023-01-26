package com.banquito.core.recaudos.service;

import org.springframework.stereotype.Service;

import com.banquito.core.recaudos.exception.CRUDException;
import com.banquito.core.recaudos.model.TarifaComision;
import com.banquito.core.recaudos.repository.TarifaComisionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TarifaComisionService {

    private final TarifaComisionRepository tarifaComisionRepository;

    public TarifaComisionService(TarifaComisionRepository tarifaComision) {
        this.tarifaComisionRepository = tarifaComision;
    }

    public TarifaComision obtenerComisionCodigo(String codigo) {
        log.info("Va a consultar la comision de la tarifa con el codigo: {}", codigo);
        TarifaComision tarifa = this.tarifaComisionRepository.findByCodigoTarifaComision(codigo);
        log.debug("La comision de la tarifa consultada por el nombre es: {} -> {}", codigo, tarifa);
        return tarifa;
    }

    public TarifaComision obtenerComisionTipoServicio(){
        log.info("Va a consultar la comision de la tarifa con el tipo de servicio: {}");
        TarifaComision tarifa = this.tarifaComisionRepository.findByTipoServicio("tipoServicio");
        log.debug("La comision de la tarifa consultada por el nombre es: {} -> {}", "tipoServicio", tarifa);
        return tarifa;
    }

    public TarifaComision obtenerComisionEstado(){
        log.info("Va a consultar la comision de la tarifa con el estado: {}");
        TarifaComision tarifa = this.tarifaComisionRepository.findByEstado("estado");
        log.debug("La comision de la tarifa consultada por el nombre es: {} -> {}", "estado", tarifa);
        return tarifa;
    }

    public void crearTarifaComision(TarifaComision tarifa) throws CRUDException {
        log.info("Va a crear la tarifa de comision:");
        log.debug("Datos de la tarifa de comision a ser creado {}", tarifa);
        try {
            tarifa.setCodigoTarifaComision(generarCodigo(3));
            this.tarifaComisionRepository.save(tarifa);
        } catch (Exception e) {
            log.error("Error al crear el producto de recaudo: {}, con los datos: {}", e.getMessage(), tarifa);
            throw new CRUDException("No se pudo crear el producto de recaudo " + e.getMessage(), e);
        }

    }

    public void actualizarTarifaComision(TarifaComision tarifa) throws CRUDException {
        log.info("Va a actualizar el producto de recaudo con la siguiete informacion: {}", tarifa);
        try {
            TarifaComision tarifaTemp = this.tarifaComisionRepository
                    .findByCodigoTarifaComision(tarifa.getCodigoTarifaComision());
            if (tarifaTemp == null) {
                throw new CRUDException(
                        "No se encontro el producto de recaudo con el codigo: " + tarifa.getCodigoTarifaComision());
            }
            tarifaTemp.setCodigoTarifaComision(tarifa.getCodigoTarifaComision());
            tarifaTemp.setTipoServicio(tarifa.getTipoServicio());
            tarifaTemp.setValor(tarifa.getValor());
            tarifaTemp.setEstado(tarifa.getEstado());
            tarifaTemp.setFechaInicio(tarifa.getFechaInicio());
            tarifaTemp.setFechaFin(tarifa.getFechaFin());
            this.tarifaComisionRepository.save(tarifaTemp);

        } catch (Exception e) {
            log.error("Error al actualizar la comision de la tarifa: {}, con los datos: {}", e.getMessage(), tarifa);
            throw new CRUDException("No se pudo actualizar la comision de la tarifa" + e.getMessage(), e);
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
