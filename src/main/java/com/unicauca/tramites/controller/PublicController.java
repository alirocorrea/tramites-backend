package com.unicauca.tramites.controller;

import com.unicauca.tramites.util.Constants;
import com.unicauca.tramites.util.Util;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(info = @Info(title = Constants.SWAGGER_TITLE, description = Constants.SWAGGER_DESCRIPTION, version = Constants.SWAGGER_VERSION))
@Tag(name = "Public Controller" , description = "Controlador con servicios públicos")
@RestController
@RequestMapping("/public")
public class PublicController {

    @Operation(summary = "Hace ping al servidor obteniendo una mensaje de respuesta")
    @GetMapping("/ping")
    public String getPingMessage() {
        return "Respuesta desde el servidor " + Util.getDateTimeString();
    }
}
