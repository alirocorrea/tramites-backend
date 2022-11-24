package com.unicauca.tramites.service.impl;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.repository.DependenciaRepository;
import com.unicauca.tramites.repository.TipoTramitesRepository;
import com.unicauca.tramites.repository.TramitesRepository;
import com.unicauca.tramites.service.TramitesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class TramitesServiceImpl implements TramitesService {


    private TramitesRepository tramitesRepository;
    private DependenciaRepository dependenciaRepository;
    private TipoTramitesRepository tipoTramitesRepository;
    @Override
    public Tramite registrarTramite(Tramite tramite) {

        if(validarVU(tramite) && validarTipoTramite(tramite) && validarDependencia(tramite)){
            return  tramitesRepository.save(tramite);
        }
        return  null;
    }

    private boolean validarTipoTramite(Tramite tramite){
        try {
            tipoTramitesRepository.findById(tramite.getTipoTramite().getId());
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private boolean validarDependencia(Tramite tramite){
        try {
            dependenciaRepository.findById(tramite.getDependencia().getId());
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private boolean validarVU(Tramite tramite){

        int numeroTramites = tramitesRepository.numeroTramites(tramite.getNumeroVU());
        if(numeroTramites == 0){
            return true;
        }
        return false;
    }

}