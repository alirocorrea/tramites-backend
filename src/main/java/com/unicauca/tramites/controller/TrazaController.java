package com.unicauca.tramites.controller;

import com.unicauca.tramites.dto.TrazaRequest;
import com.unicauca.tramites.dto.TrazaResponse;
import com.unicauca.tramites.service.TrazaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Traza Controller" , description = "Servicios relacionados con las trazas de los tramites")
@RestController
@RequestMapping("/api/traza")
public class TrazaController {
    private TrazaService trazaService;

    @Operation(summary = "Registrar una nueva traza")
    @PostMapping
    public TrazaResponse registrarTramite(@RequestBody TrazaRequest trazaRequest) {
        return trazaService.registrarTraza(trazaRequest);
    }
    @Operation(summary = "Mostrar la trazabilidad de un tramite")
    @GetMapping
    public List<TrazaResponse> trazabilidad(@RequestParam Long numeroVU ) {
        return trazaService.verTraza(numeroVU);
    }
}
