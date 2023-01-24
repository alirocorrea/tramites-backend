package com.unicauca.tramites.service;


import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.dto.TrazaRequest;
import com.unicauca.tramites.dto.TrazaResponse;

import java.util.List;

public interface TrazaService {

    TrazaResponse registrarTraza(TrazaRequest trazaRequest) ;
    TramiteResponse verTraza(Long numeroVU);
}
