package com.unicauca.tramites.controller;

import com.unicauca.tramites.dto.*;
import com.unicauca.tramites.service.TramitesService;
import com.unicauca.tramites.service.TrazaService;
import com.unicauca.tramites.util.reportes.TramiteExporterExcel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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

    @Operation(summary = "Exportar tramites a excel")
    @PostMapping("/exportarExcel")
    public void exportarTramitesEnExcel(HttpServletResponse response, @RequestBody RequestReporteFechas requestReporteFechas) throws IOException {
       response.setContentType("application/octet-stream");

       String cabecera = "Content-Disposition";
       String valor = "attachment; filename=Tramites_"+ LocalDate.now() +".xlsx";
       response.setHeader(cabecera,valor);

       List<ListaTramiteResponse> tramiteResponses = tramitesService.reporteTramitesPorFecha(requestReporteFechas.getFechaInicial(), requestReporteFechas.getFechafinal());

       TramiteExporterExcel tramiteExporterExcel = new TramiteExporterExcel(tramiteResponses);
       tramiteExporterExcel.exportar(response);

    }


}