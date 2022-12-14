package com.unicauca.tramites.controller;

import com.unicauca.tramites.dto.PingResponse;
import com.unicauca.tramites.service.PingService;
import com.unicauca.tramites.common.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@OpenAPIDefinition(info = @Info(title = Constants.SWAGGER_TITLE, description = Constants.SWAGGER_DESCRIPTION, version = Constants.SWAGGER_VERSION), servers = {@Server(url = "/", description = "Default Server URL")})
@Tag(name = "Ping Controller" , description = "Servicios para comprobar la conexión")
@RestController
@RequestMapping("/api/ping")
public class PingController {

    private PingService pingService;

    @Operation(summary = "Comprueba la conexión con el servidor")
    @GetMapping("/server")
    public ResponseEntity<PingResponse> getPingMessageServer() {
        return ResponseEntity.ok(pingService.getPingMessageServer());
    }

    @Operation(summary = "Comprueba la conexión con la base de datos")
    @GetMapping("/db")
    public ResponseEntity<PingResponse> getPingMessageDB() {
        return ResponseEntity.ok(pingService.getPingMessageDB());
    }
}
