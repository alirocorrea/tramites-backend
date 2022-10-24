package com.unicauca.tramites.controller;

import com.unicauca.tramites.dto.PingDTO;
import com.unicauca.tramites.service.PingService;
import com.unicauca.tramites.common.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(info = @Info(title = Constants.SWAGGER_TITLE, description = Constants.SWAGGER_DESCRIPTION, version = Constants.SWAGGER_VERSION))
@Tag(name = "Ping Controller" , description = "Endpoints para pruebas de conexión")
@RestController
@RequestMapping("/ping")
@AllArgsConstructor
public class PingController {

    private PingService pingService;

    @Operation(summary = "Hace ping al servidor obteniendo una mensaje de confirmación")
    @GetMapping("/server")
    public ResponseEntity<PingDTO> getPingMessageServer() {
        return ResponseEntity.ok(pingService.getPingMessageServer());
    }

    @Operation(summary = "Hace ping a la base de datos obteniendo una mensaje de confirmación")
    @GetMapping("/db")
    public ResponseEntity<PingDTO> getPingMessageDB() {
        return ResponseEntity.ok(pingService.getPingMessageDB());
    }
}
