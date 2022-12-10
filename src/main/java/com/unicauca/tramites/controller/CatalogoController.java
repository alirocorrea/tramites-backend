package com.unicauca.tramites.controller;

import com.unicauca.tramites.dto.CatalogoReponse;
import com.unicauca.tramites.service.CatalogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Catalogo Controller" , description = "Servicios relacionados con los catálogos")
@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

    private CatalogoService catalogoService;

    @Operation(summary = "Obtener los tipos de recepción del trámite")
    @GetMapping("/tipo-recepcion")
    public ResponseEntity<List<CatalogoReponse>> getTipoRecepcion() {
        return ResponseEntity.ok(catalogoService.getTipoRecepcion());
    }

    @Operation(summary = "Obtener los tipos de trámite")
    @GetMapping("/tipo-tramite")
    public ResponseEntity<List<CatalogoReponse>> getTipoTramite() {
        return ResponseEntity.ok(catalogoService.getTipoTramite());
    }

    @Operation(summary = "Obtener las dependencias")
    @GetMapping("/dependencia")
    public ResponseEntity<List<CatalogoReponse>> getDependencia() {
        return ResponseEntity.ok(catalogoService.getDependencia());
    }

    @Operation(summary = "Obtener los tipos de peticionarios")
    @GetMapping("/tipo-peticionario")
    public ResponseEntity<List<CatalogoReponse>> getTipoPeticionario() {
        return ResponseEntity.ok(catalogoService.getTipoPeticionario());
    }
}
