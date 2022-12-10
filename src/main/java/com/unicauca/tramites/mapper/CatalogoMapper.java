package com.unicauca.tramites.mapper;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.domain.Dependencia;
import com.unicauca.tramites.domain.TipoPeticionario;
import com.unicauca.tramites.domain.TipoRecepcion;
import com.unicauca.tramites.domain.TipoTramite;
import com.unicauca.tramites.dto.CatalogoReponse;

public final class CatalogoMapper {
    private CatalogoMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static CatalogoReponse mapTipoRecepcion(TipoRecepcion tipoRecepcion) {
        return CatalogoReponse.builder()
                .id(tipoRecepcion.getId())
                .descripcion(tipoRecepcion.getDescripcion())
                .build();
    }

    public static CatalogoReponse mapTipoTramite(TipoTramite tipoTramite) {
        return CatalogoReponse.builder()
                .id(tipoTramite.getId())
                .descripcion(tipoTramite.getDescripcion())
                .build();
    }

    public static CatalogoReponse mapDependencia(Dependencia dependencia) {
        return CatalogoReponse.builder()
                .id(dependencia.getId())
                .descripcion(dependencia.getDescripcion())
                .build();
    }

    public static CatalogoReponse mapTipoPeticionario(TipoPeticionario tipoPeticionario) {
        return CatalogoReponse.builder()
                .id(tipoPeticionario.getId())
                .descripcion(tipoPeticionario.getDescripcion())
                .build();
    }
}
