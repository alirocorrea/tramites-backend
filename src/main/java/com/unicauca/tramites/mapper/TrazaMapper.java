package com.unicauca.tramites.mapper;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.domain.Traza;
import com.unicauca.tramites.dto.TrazaRequest;
import com.unicauca.tramites.dto.TrazaResponse;

public class TrazaMapper {

    private TrazaMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static Traza mapearEntidad(TrazaRequest trazaRequest) {
        return Traza.builder()
                .descripcion(trazaRequest.getDescripcion())
                .numeroOficio(trazaRequest.getNumeroOficio())
                .build();
    }
    public static TrazaResponse mapearResponse(Traza traza) {
        return TrazaResponse.builder()
                .fechaCreacion(traza.getFechaCreacion().toString())
                .descripcion(traza.getDescripcion())
                .dependencia(traza.getDependencia().getDescripcion())
                .activo(traza.getActivo())
                .numeroOficio(traza.getNumeroOficio())
                .build();
    }

}
