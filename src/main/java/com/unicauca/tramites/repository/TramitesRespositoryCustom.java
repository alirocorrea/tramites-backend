package com.unicauca.tramites.repository;

import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.ListaTramiteRequest;

import java.util.List;

public interface TramitesRespositoryCustom {

    List<Tramite> getTramitesFiltros(ListaTramiteRequest filtros);
}
