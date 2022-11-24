package com.unicauca.tramites.repository;

import com.unicauca.tramites.domain.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface TramitesRepository extends JpaRepository<Tramite, Long> {

   @Query(
           value = "SELECT count(*) FROM tbl_tramite WHERE tbl_tramite.NUMEROVU = ?",
           nativeQuery = true
   )
   public int numeroTramites(@Param("numeroVu")long numeroVU);
}
