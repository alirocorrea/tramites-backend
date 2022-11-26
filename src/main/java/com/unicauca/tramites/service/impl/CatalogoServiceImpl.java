package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.domain.EntidadPrincipal;
import com.unicauca.tramites.dto.CatalogoReponse;
import com.unicauca.tramites.mapper.CatalogoMapper;
import com.unicauca.tramites.repository.DependenciaRepository;
import com.unicauca.tramites.repository.TipoRecepcionRepository;
import com.unicauca.tramites.repository.TipoTramitesRepository;
import com.unicauca.tramites.service.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {

    private TipoRecepcionRepository tipoRecepcionRepository;
    private TipoTramitesRepository tipoTramitesRepository;
    private DependenciaRepository dependenciaRepository;

    @Override
    public List<CatalogoReponse> getTipoRecepcion() {
        return tipoRecepcionRepository.findAll().stream()
                .map(CatalogoMapper::mapTipoRecepcion)
                .collect(Collectors.toList());
    }

    @Override
    public List<CatalogoReponse> getTipoTramite() {
        return tipoTramitesRepository.findAll().stream()
                .filter(EntidadPrincipal::getActivo)
                .map(CatalogoMapper::mapTipoTramite)
                .collect(Collectors.toList());
    }

    @Override
    public List<CatalogoReponse> getDependencia() {
        return  dependenciaRepository.findAll().stream()
                .filter(EntidadPrincipal::getActivo)
                .map(CatalogoMapper::mapDependencia)
                .collect(Collectors.toList());
    }
}
