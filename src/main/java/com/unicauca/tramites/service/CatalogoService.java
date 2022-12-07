package com.unicauca.tramites.service;

import com.unicauca.tramites.dto.CatalogoReponse;

import java.util.List;

public interface CatalogoService {

    List<CatalogoReponse> getTipoRecepcion();

    List<CatalogoReponse> getTipoTramite();

    List<CatalogoReponse> getDependencia();

    List<CatalogoReponse> getTipoPeticionario();

}
