package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.Dependencia;
import com.unicauca.tramites.domain.TipoRecepcion;
import com.unicauca.tramites.domain.TipoTramite;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.exception.ApplicationException;
import com.unicauca.tramites.mapper.TramiteMapper;
import com.unicauca.tramites.repository.DependenciaRepository;
import com.unicauca.tramites.repository.TipoRecepcionRepository;
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
    private TipoRecepcionRepository tipoRecepcionRepository;

    @Override
    public TramiteResponse registrarTramite(TramiteRequest request) {
        if (!esValidoNumeroVU(request)) {
            return null;
        }
        TipoTramite tipoTramite = tipoTramitesRepository.findById(request.getIdTipoTramite())
                .orElseThrow(() -> new ApplicationException(Constants.ID_TIPO_TRAMITE_INVALIDO));
        Dependencia dependencia = dependenciaRepository.findById(request.getIdDependencia())
                .orElseThrow(() -> new ApplicationException(Constants.ID_DEPENDENCIA_INVALIDO));
        TipoRecepcion tipoRecepcion = Util.isNotNull(request.getIdTipoRecepcion()) ?
                tipoRecepcionRepository.findById(request.getIdTipoRecepcion())
                        .orElseThrow(() -> new ApplicationException(Constants.ID_TIPO_RECEPCION_INVALIDO)) : null ;

        Tramite tramite = TramiteMapper.mapearEntidad(request);
        tramite.setTipoTramite(tipoTramite);
        tramite.setDependencia(dependencia);
        tramite.setTipoRecepcion(tipoRecepcion);
        if(!esValidaFechaRecepcion(tramite)){
            throw new ApplicationException(Constants.FECHA_INVALIDA);
        }
        tramite.setFechaVencimiento(calcularFechaVencimiento(tramite, tipoTramite));
        return TramiteMapper.mapearResponse(tramitesRepository.save(tramite));
    }

    private boolean esValidoNumeroVU(TramiteRequest request) {
        return tramitesRepository.numeroTramites(request.getNumeroVU()) == 0;
    }

    private boolean esValidaFechaRecepcion(Tramite tramite) {
        return Util.esFechaMenorIgualActual(tramite.getFechaRecepcion());
    }

    private LocalDate calcularFechaVencimiento(Tramite tramite, TipoTramite tipoTramite) {
        return tramite.getFechaRecepcion().plusDays(tipoTramite.getVigencia());
    }
}