package com.unicauca.tramites.repository;


import com.unicauca.tramites.domain.Traza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrazaRepository extends JpaRepository<Traza, Long> {

    @Query("SELECT t, tr FROM Tramite tr INNER JOIN tr.trazas t where tr.numeroVU = ?1  ")
    Optional<List<Traza>> trazaPorVU(Long numeroVU);
}
