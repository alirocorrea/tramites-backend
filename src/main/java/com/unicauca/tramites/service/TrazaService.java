package com.unicauca.tramites.service;


import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.dto.TrazaRequest;
import com.unicauca.tramites.dto.TrazaResponse;


public interface TrazaService {

    TrazaResponse registrarTraza(TrazaRequest trazaRequest) ;
    TramiteResponse verTraza(Long numeroVU);
}
