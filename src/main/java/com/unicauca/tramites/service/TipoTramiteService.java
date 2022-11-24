package com.unicauca.tramites.service;

import com.unicauca.tramites.domain.TipoTramite;

import java.util.ArrayList;

public interface TipoTramiteService {
    ArrayList<TipoTramite> listarTipoTramites() throws Exception;
}
