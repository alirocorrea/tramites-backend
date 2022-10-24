package com.unicauca.tramites.repository;

import com.unicauca.tramites.domain.Configuraciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionesRepository extends JpaRepository<Configuraciones, Long> {

}
