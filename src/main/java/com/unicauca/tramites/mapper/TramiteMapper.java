package com.unicauca.tramites.mapper;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;

public final class TramiteMapper {

    private TramiteMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static Tramite mapearEntidad(TramiteRequest tramiteRequest) {
        return Tramite.builder()
                .numeroVU(tramiteRequest.getNumeroVU())
                .correo(tramiteRequest.getCorreo())
                .celular(tramiteRequest.getCelular())
                .telefono(tramiteRequest.getTelefono())
                .direccion(tramiteRequest.getDireccion())
                .asunto(tramiteRequest.getAsunto())
                .numeroOficio(tramiteRequest.getNumeroOficio())
                .descripcion(tramiteRequest.getDescripcion())
                .nombrePeticionario(tramiteRequest.getNombrePeticionario())
                .fechaRecepcion(Util.stringToLocalDate(tramiteRequest.getFechaRecepcion()))
                .build();
    }

    public static TramiteResponse mapearResponse(Tramite tramite) {
        return TramiteResponse.builder().id(tramite.getId()).build();
    }
}
