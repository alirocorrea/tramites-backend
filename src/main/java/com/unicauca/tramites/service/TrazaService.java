package com.unicauca.tramites.service;


import com.unicauca.tramites.dto.TrazaRequest;
import com.unicauca.tramites.dto.TrazaResponse;

import java.util.List;

public interface TrazaService {

    TrazaResponse registrarTraza(TrazaRequest trazaRequest) ;
    List<TrazaResponse> verTraza(Long numeroVU);
}
