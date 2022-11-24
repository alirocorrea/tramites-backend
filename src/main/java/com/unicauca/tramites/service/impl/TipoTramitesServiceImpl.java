package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.domain.TipoTramite;
import com.unicauca.tramites.repository.TipoTramitesRepository;
import com.unicauca.tramites.service.TipoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class TipoTramitesServiceImpl implements TipoTramiteService {
    @Autowired
    TipoTramitesRepository tipoTramitesRepository;
    public ArrayList<TipoTramite> listarTipoTramites() {
        return (ArrayList<TipoTramite>) tipoTramitesRepository.findAll();
    }
}
