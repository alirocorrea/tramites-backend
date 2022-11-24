package com.unicauca.tramites.controller;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.domain.Tramite;
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
//@OpenAPIDefinition(info = @Info(title = Constants.SWAGGER_TITLE, description = Constants.SWAGGER_DESCRIPTION, version = Constants.SWAGGER_VERSION))
@Tag(name = "Tramite Controller" , description = "Servicios para registrar tramites")
@RestController
@RequestMapping("/ping")
public class TramiteController {

    private TramitesService tramitesService;

    @Operation(summary = "Registra un tramite")
    @PostMapping("/tramite")
    public Tramite registrarTramite(@RequestBody Tramite tramite)throws Exception {
        return tramitesService.registrarTramite(tramite);
    }
}
