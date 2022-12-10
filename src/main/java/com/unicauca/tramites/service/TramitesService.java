package com.unicauca.tramites.service;

import com.unicauca.tramites.dto.ListaTramiteRequest;
import com.unicauca.tramites.dto.ListaTramiteResponse;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;

import java.util.List;


public interface TramitesService {
    TramiteResponse registrarTramite(TramiteRequest tramiteRequest) ;

    List<ListaTramiteResponse> listaTramites(ListaTramiteRequest request);
}
