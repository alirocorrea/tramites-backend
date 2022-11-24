package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.domain.Dependencia;
import com.unicauca.tramites.repository.DependenciaRepository;
import com.unicauca.tramites.service.DependenciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@AllArgsConstructor
public class DependenciaServiceImpl implements DependenciaService {

    DependenciaRepository dependenciaRepository;
    @Override
    public ArrayList<Dependencia> listarDependencias(){
        return (ArrayList<Dependencia>) dependenciaRepository.findAll();
    }
}
