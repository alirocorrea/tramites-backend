package com.unicauca.tramites.controller;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.service.TramitesService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@Tag(name = "Tramite Controller" , description = "Servicios para registrar tramites")
@RestController
@RequestMapping("/api/tramite")
public class TramiteController {

    private TramitesService tramitesService;

    @Operation(summary = "Registra un tramite")
    @PostMapping
    public TramiteResponse registrarTramite(@RequestBody TramiteRequest tramiteRequest)throws Exception {
        return tramitesService.registrarTramite(tramiteRequest);
    }
}