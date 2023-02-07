package com.unicauca.tramites.repository;

import com.unicauca.tramites.domain.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Service
public interface TramitesRepository extends JpaRepository<Tramite, Long> {

   @Query("SELECT COUNT(tr) FROM Tramite tr WHERE tr.numeroVU = ?1")
   Integer numeroTramites( Long numeroVU);
   @Query("SELECT tr FROM Tramite tr WHERE tr.numeroVU = ?1")
   Optional<Tramite> tramitePorVu(Long numeroVU);
   @Query("SELECT tr FROM Tramite tr where tr.fechaRecepcion BETWEEN ?1 AND ?2")
   Optional<List<Tramite>> reporteTramitesPorRangoFecha(LocalDate fechaInicial, LocalDate fechaFinal);
}
