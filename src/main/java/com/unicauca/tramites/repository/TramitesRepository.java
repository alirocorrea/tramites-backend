package com.unicauca.tramites.repository;

import com.unicauca.tramites.domain.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface TramitesRepository extends JpaRepository<Tramite, Long> {

   @Query("SELECT COUNT(tr) FROM Tramite tr WHERE tr.numeroVU = ?1")
   Integer numeroTramites( Long numeroVU);
}
