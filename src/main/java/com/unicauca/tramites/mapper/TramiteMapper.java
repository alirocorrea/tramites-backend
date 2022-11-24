package com.unicauca.tramites.mapper;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;

import java.time.LocalDateTime;

public final class TramiteMapper {

    private TramiteMapper() {
        throw new IllegalStateException(Constants.NOT_CREATE_OBJECT);
    }

    public static Tramite mapearEntidad(TramiteRequest tramiteRequest) {
        Tramite tramite = new Tramite();
        tramite.setNumeroVU(tramiteRequest.getNumeroVU());
        tramite.setCorreo(tramiteRequest.getCorreo());
        tramite.setAsunto(tramiteRequest.getAsunto());
        tramite.setNumOficio(tramiteRequest.getNumOficio());
        tramite.setDescripcion(tramiteRequest.getDescripcion());
        tramite.setNombrePeticionario(tramiteRequest.getNombrePeticionario());
        tramite.setFechaRecepcion(Util.stringToLocalDate(tramiteRequest.getFechaRecepcion()));
        tramite.setActivo(Boolean.TRUE);
        tramite.setFechaCreacionRegistro(LocalDateTime.now());
        return tramite;
    }

    public static TramiteResponse mapearResponse(Tramite tramite) {
        return TramiteResponse.builder().id(tramite.getId()).build();
    }
}
