package com.unicauca.tramites.service;

import com.unicauca.tramites.dto.*;

import java.util.List;


public interface TramitesService {
    TramiteResponse registrarTramite(TramiteRequest tramiteRequest) ;

    List<ListaTramiteResponse> listaTramites(ListaTramiteRequest request);

    List<ListaTramiteResponse>reporteTramitesPorFecha(String fechaInicial, String FechaFinal);

}
