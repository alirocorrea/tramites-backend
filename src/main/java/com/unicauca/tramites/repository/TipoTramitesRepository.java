package com.unicauca.tramites.repository;

import com.unicauca.tramites.domain.TipoTramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface TipoTramitesRepository extends JpaRepository<TipoTramite, Long> {

}
