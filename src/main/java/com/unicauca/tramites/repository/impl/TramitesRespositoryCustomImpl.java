package com.unicauca.tramites.repository.impl;

import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.TipoTramite;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.ListaTramiteRequest;
import com.unicauca.tramites.repository.TramitesRespositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TramitesRespositoryCustomImpl implements TramitesRespositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Tramite> getTramitesFiltros(ListaTramiteRequest filtros) {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Tramite> cq = cb.createQuery(Tramite.class);
        Root<Tramite> tramite = cq.from(Tramite.class);
        Join<Tramite, TipoTramite> tipoTramiteJoin = tramite.join("tipoTramite");
        tramite.fetch("tipoTramite");

        List<Predicate> condiciones = new ArrayList<>();

        //Codicion General - Siempre se cumple independiente de los filtros
        condiciones.add(
                cb.equal(tramite.get("activo"), true)
        );
        //Codiciones Dinamicas - A partir de los filtros
        if(Util.isNotNull(filtros.getNumeroVU())){
            condiciones.add(
                    cb.equal(tramite.get("numeroVU"), filtros.getNumeroVU())
            );
        }

        if(Util.isNotNull(filtros.getIdTipoTramite())) {
            condiciones.add(
                    cb.equal(tipoTramiteJoin.get("id"), filtros.getIdTipoTramite())
            );
        }

        cq.where(condiciones.toArray(new Predicate[] {}));
        return em.createQuery(cq).getResultList();
    }
}
