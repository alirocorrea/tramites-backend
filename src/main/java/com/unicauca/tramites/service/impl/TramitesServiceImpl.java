package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.*;
import com.unicauca.tramites.dto.*;
import com.unicauca.tramites.exception.ApplicationException;
import com.unicauca.tramites.mapper.TramiteMapper;
import com.unicauca.tramites.mapper.TrazaMapper;
import com.unicauca.tramites.repository.*;
import com.unicauca.tramites.service.TramitesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TramitesServiceImpl implements TramitesService {

    private TramitesRepository tramitesRepository;
    private DependenciaRepository dependenciaRepository;
    private TipoTramitesRepository tipoTramitesRepository;
    private TipoRecepcionRepository tipoRecepcionRepository;
    private TramitesRespositoryCustom tramitesRespositoryCustom;
    private TipoPeticionarioRepository tipoPeticionarioRepository;
    private TrazaRepository trazaRepository;
    @Override
    public TramiteResponse registrarTramite(TramiteRequest request) {
        if (!esValidoNumeroVU(request)) {
            return null;
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

        TramiteResponse tramiteResponse = TramiteMapper.mapearResponse(tramitesRepository.save(tramite));

        trazaRepository.save(retornarTrazaInicial(tramite));

        return tramiteResponse;
    }

    @Override
    public List<ListaTramiteResponse> listaTramites(ListaTramiteRequest request) {
        List<Tramite> tramiteList = tramitesRespositoryCustom.getTramitesFiltros(request);
        return  tramiteList.stream()
                .map(TramiteMapper::mapearListaTramiteResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListaTramiteResponse> reporteTramitesPorFecha(String fechaInicial, String fechaFinal) {

        List<Tramite>tramiteList = tramitesRepository.reporteTramitesPorRangoFecha(Util.stringToLocalDate(fechaInicial),Util.stringToLocalDate(fechaFinal)).orElse(null);
        if(tramiteList!=null){
            return  tramiteList.stream()
                    .map(TramiteMapper::mapearListaTramiteResponse)
                    .collect(Collectors.toList());
        }else{
            throw new ApplicationException(Constants.ERROR_SIN_DATOS_EN_RANGO);
        }
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
    private Traza retornarTrazaInicial(Tramite tramite){

        TrazaRequest trazaRequest = new TrazaRequest();

        trazaRequest.setNumeroVU(tramite.getNumeroVU());
        trazaRequest.setIdDependencia(tramite.getDependencia().getId());
        trazaRequest.setNumeroOficio(tramite.getNumeroOficio());
        trazaRequest.setDescripcion(tramite.getDescripcion());
        Traza traza = TrazaMapper.mapearEntidad(trazaRequest);
        traza.setTbl_tramite(tramite);
        traza.setDependencia(tramite.getDependencia());

        return traza;

    }
}