package com.unicauca.tramites.repository;

import com.unicauca.tramites.domain.Dependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface DependenciaRepository extends JpaRepository<Dependencia, Long> {

}
