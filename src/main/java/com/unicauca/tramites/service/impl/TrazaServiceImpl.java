package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.domain.*;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.dto.TrazaRequest;
import com.unicauca.tramites.dto.TrazaResponse;
import com.unicauca.tramites.exception.ApplicationException;
import com.unicauca.tramites.mapper.TramiteMapper;
import com.unicauca.tramites.mapper.TrazaMapper;
import com.unicauca.tramites.repository.*;
import com.unicauca.tramites.service.TrazaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TrazaServiceImpl implements TrazaService {

    private TrazaRepository trazaRepository;
    private TramitesRepository tramitesRepository;
    private DependenciaRepository dependenciaRepository;
    private TipoTramitesRepository tipoTramitesRepository;


    @Override
    public TrazaResponse registrarTraza(TrazaRequest trazaRequest) {

        if(!validarUltimoNodo(trazaRequest))
            throw new ApplicationException(Constants.ERROR_IGUAL_DEPENDENCIA);

        Dependencia dependencia = dependenciaRepository.findById(trazaRequest.getIdDependencia())
                .orElseThrow(() -> new ApplicationException(Constants.ID_DEPENDENCIA_INVALIDO)) ;

        Tramite tramite = tramitesRepository.tramitePorVu(trazaRequest.getNumeroVU())
                .orElseThrow(() -> new ApplicationException(Constants.ERROR_NUMERO_VU_NO_EXISTE)) ;

        TipoTramite tipoTramite = tipoTramitesRepository.findById(tramite.getTipoTramite().getId())
                .orElseThrow(() -> new ApplicationException(Constants.ID_TIPO_TRAMITE_INVALIDO));

        Traza traza = TrazaMapper.mapearEntidad(trazaRequest);
        traza.setDependencia(dependencia);
        traza.setTbl_tramite(tramite);

        return TrazaMapper.mapearResponse(trazaRepository.save(traza));
    }

    @Override
    public TramiteResponse verTraza(Long numeroVU) {

        List<Traza>trazabilidad = trazaRepository.trazaPorVU(numeroVU)
                .orElseThrow(() -> new ApplicationException(Constants.ID_DEPENDENCIA_INVALIDO)) ;
        List<TrazaResponse>trazaResponseList = new ArrayList<>();
        for(Traza objTraza :trazabilidad) {
            trazaResponseList.add(TrazaMapper.mapearResponse(objTraza));
        }
       Tramite tramite = tramitesRepository.tramitePorVu(numeroVU).orElseThrow(()->new ApplicationException(Constants.ERROR_NUMERO_VU_NO_EXISTE));
       TramiteResponse tramiteResponse = TramiteMapper.mapearResponse(tramite);
       tramiteResponse.setTraza(trazaResponseList);
       return  tramiteResponse;
    }

    private boolean validarUltimoNodo(TrazaRequest trazaRequest){
        List<Traza> trazabilidad = trazaRepository.trazaPorVU(trazaRequest.getNumeroVU()).orElse(null);
        if(trazabilidad != null && !trazabilidad.isEmpty()){
            Dependencia ultimaDependencia = trazabilidad.get(trazabilidad.size()-1).getDependencia();
            return !ultimaDependencia.getId().equals(trazaRequest.getIdDependencia());
        }
        return Boolean.TRUE;
    }


}
