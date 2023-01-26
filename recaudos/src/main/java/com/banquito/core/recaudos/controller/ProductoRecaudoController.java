package com.banquito.core.recaudos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.recaudos.exception.CRUDException;
import com.banquito.core.recaudos.model.ProductoRecaudo;
import com.banquito.core.recaudos.service.ProductoRecaudoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/producto-recaudo")
public class ProductoRecaudoController {
    ProductoRecaudoService productoRecaudoService;

    public ProductoRecaudoController(ProductoRecaudoService productoRecaudoService) {
        this.productoRecaudoService = productoRecaudoService;
    }

    @GetMapping("/{codigoProductoRecaudo}")
    public ResponseEntity<ProductoRecaudo> getProductoRecaudo(
            @PathVariable("codigoProductoRecaudo") String codigoProductoRecaudo) {
        log.info("Obteniendo codigo producto recaudo con codigo {}", codigoProductoRecaudo);
        ProductoRecaudo recaudo = productoRecaudoService.obtenerRecaudoCodigo(codigoProductoRecaudo);
        if (recaudo != null) {
            return ResponseEntity.ok(recaudo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ProductoRecaudo> getTarifaComisionTipoServicio(@PathVariable("nombre") String nombre) {
        log.info("Obteniendo producto recaudo con nnombre {}", nombre);
        ProductoRecaudo recaudo = productoRecaudoService.obtenerRecaudoNombre(nombre);
        if (recaudo != null) {
            return ResponseEntity.ok(recaudo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> crearTarifaComision(@RequestBody ProductoRecaudo recaudo) {

        try {
            this.productoRecaudoService.crearProductoRecaudo(recaudo);
            return ResponseEntity.ok().build();

        } catch (CRUDException e) {
            log.error("Error al crear el producto de recaudo {}", e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping
    public ResponseEntity<String> actualizarTarifaComision(@RequestBody ProductoRecaudo recaudo) {

        try {
            this.productoRecaudoService.actualizarProductoRecaudo(recaudo);
            return ResponseEntity.ok().build();

        } catch (CRUDException e) {
            log.error("Error al actualizar el producto de recaudo {}", e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }

    }
}
