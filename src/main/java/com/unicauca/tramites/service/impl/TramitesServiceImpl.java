package com.unicauca.tramites.service.impl;
import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.Dependencia;
import com.unicauca.tramites.domain.TipoTramite;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.exception.ApplicationException;
import com.unicauca.tramites.mapper.TramiteMapper;
import com.unicauca.tramites.repository.DependenciaRepository;
import com.unicauca.tramites.repository.TipoTramitesRepository;
import com.unicauca.tramites.repository.TramitesRepository;
import com.unicauca.tramites.service.TramitesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class TramitesServiceImpl implements TramitesService {

    private TramitesRepository tramitesRepository;
    private DependenciaRepository dependenciaRepository;
    private TipoTramitesRepository tipoTramitesRepository;

    @Override
    public TramiteResponse registrarTramite(TramiteRequest tramiteRequest) {
        if(!validarNumeroVU(tramiteRequest)) {
            return null;
        }
        TipoTramite tipoTramite = tipoTramitesRepository.findById(tramiteRequest.getIdTipoTramite()).orElse(null);
        Dependencia dependencia = dependenciaRepository.findById(tramiteRequest.getIdDependencia()).orElse(null);

        if(tipoTramite == null || dependencia == null){
            throw new ApplicationException(Constants.ID_FORANEAS_TRAMITES_INVALIDOS);
        }

        Tramite tramite = TramiteMapper.mapearEntidad(tramiteRequest);
        tramite.setTipoTramite(tipoTramite);
        tramite.setDependencia(dependencia);

        if(!validarFechaRecepcion(tramite))
            throw new ApplicationException(Constants.FECHA_INVALIDA);
        calcularFechaVencimiento(tramite,tipoTramite);
        return TramiteMapper.mapearResponse(tramitesRepository.save(tramite));
    }

    private boolean validarNumeroVU(TramiteRequest tramiteRequest){
        Integer numeroTramites = tramitesRepository.numeroTramites(tramiteRequest.getNumeroVU());
        return (numeroTramites == 0);
    }

    private boolean validarFechaRecepcion(Tramite tramite){
        if(tramite.getFechaRecepcion().compareTo(LocalDate.now())>0){
            return false;
        }
        return true;
    }
    private void calcularFechaVencimiento(Tramite tramite, TipoTramite tipoTramite){

        LocalDate fechaVencimiento = tramite.getFechaRecepcion().plusDays(tipoTramite.getVigencia());
        tramite.setFechaVencimiento(fechaVencimiento);
    }

}