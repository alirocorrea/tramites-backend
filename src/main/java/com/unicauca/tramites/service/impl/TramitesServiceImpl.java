package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.*;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.exception.ApplicationException;
import com.unicauca.tramites.mapper.TramiteMapper;
import com.unicauca.tramites.repository.*;
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

    private TipoPeticionarioRepository tipoPeticionarioRepository;

    @Override
    public TramiteResponse registrarTramite(TramiteRequest request) {
        if (!esValidoNumeroVU(request)) {
            throw new ApplicationException(Constants.ERROR_NUMERO_VU);
        }
        TipoPeticionario tipoPeticionario = tipoPeticionarioRepository.findById(request.getIdTipoTipoPeticionario())
                .orElseThrow(() -> new ApplicationException(Constants.ERROR_TIPO_PETICIONARIO)) ;

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
        tramite.setTipoPeticionario((tipoPeticionario));
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