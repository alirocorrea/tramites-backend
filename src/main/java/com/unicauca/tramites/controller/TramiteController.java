package com.unicauca.tramites.controller;

import com.unicauca.tramites.dto.ListaTramiteRequest;
import com.unicauca.tramites.dto.ListaTramiteResponse;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.service.TramitesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@Tag(name = "Tramite Controller" , description = "Servicios relacionados con los trámites")
@RestController
@RequestMapping("/api/tramite")
public class TramiteController {

    private TramitesService tramitesService;

    @Operation(summary = "Registrar un nuevo trámite")
    @PostMapping
    public TramiteResponse registrarTramite(@RequestBody TramiteRequest tramiteRequest) {
        return tramitesService.registrarTramite(tramiteRequest);
    }

    @Operation(summary = "Listar los trámite con filtros")
    @PostMapping("/lista")
    public List<ListaTramiteResponse> listarTramite(@RequestBody ListaTramiteRequest listaTramiteRequest) {
        return tramitesService.listaTramites(listaTramiteRequest);
    }
}