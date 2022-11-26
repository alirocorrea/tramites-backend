package com.unicauca.tramites.service;

import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;


public interface TramitesService {
    TramiteResponse registrarTramite(TramiteRequest tramiteRequest) ;
}
