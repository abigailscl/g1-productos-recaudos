package com.banquito.core.recaudos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.recaudos.exception.CRUDException;
import com.banquito.core.recaudos.model.TarifaComision;
import com.banquito.core.recaudos.service.TarifaComisionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/tarifa-comision")
public class TarifaComisionController {

    private final TarifaComisionService tarifaComisionService;

    public TarifaComisionController(TarifaComisionService tarifaComisionService) {
        this.tarifaComisionService = tarifaComisionService;
    }

    @GetMapping("/{codigoTarifaComision}")
    public ResponseEntity<TarifaComision> getTarifaComision(String codigoTarifaComision) {
        log.info("Obteniendo tarifa comision con codigo {}", codigoTarifaComision);
        TarifaComision tarifaComision = tarifaComisionService.obtenerComisionCodigo(codigoTarifaComision);
        if (tarifaComision != null) {
            return ResponseEntity.ok(tarifaComision);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{tipo-servicio}")
    public ResponseEntity<TarifaComision> getTarifaComisionTipoServicio() {
        log.info("Obteniendo tarifa comision con tipo de servicio");
        TarifaComision tarifaComision = tarifaComisionService.obtenerComisionTipoServicio();
        if (tarifaComision != null) {
            return ResponseEntity.ok(tarifaComision);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{estado}")
    public ResponseEntity<TarifaComision> getTarifaComisionEstado() {
        log.info("Obteniendo tarifa comision con estado");
        TarifaComision tarifaComision = tarifaComisionService.obtenerComisionEstado();
        if (tarifaComision != null) {
            return ResponseEntity.ok(tarifaComision);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> crearTarifaComision(TarifaComision tarifaComision) {

        try {
            this.tarifaComisionService.crearTarifaComision(tarifaComision);
            return ResponseEntity.ok().build();

        } catch (CRUDException e) {
            log.error("Error al crear la tarifa comision {}", e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping
    public ResponseEntity<String> actualizarTarifaComision(TarifaComision tarifaComision) {

        try {
            this.tarifaComisionService.actualizarTarifaComision(tarifaComision);
            return ResponseEntity.ok().build();

        } catch (CRUDException e) {
            log.error("Error al actualizar la tarifa comision {}", e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }

    }

}
