package com.unicauca.tramites.mapper;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;
import com.unicauca.tramites.domain.Tramite;
import com.unicauca.tramites.dto.ListaTramiteResponse;
import com.unicauca.tramites.dto.TramiteRequest;
import com.unicauca.tramites.dto.TramiteResponse;
import com.unicauca.tramites.dto.TrazaResponse;

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
        return TramiteResponse.builder().id(tramite.getId())
                .Asunto(tramite.getAsunto())
                .tipoPQRSF(tramite.getTipoTramite().getDescripcion())
                .peticionario(tramite.getNombrePeticionario())
                .tipoPeticionario((tramite.getTipoPeticionario().getDescripcion()))
                .numeroOficio((tramite.getNumeroOficio()))
                .dependencia(tramite.getDependencia().getDescripcion())
                .email(tramite.getCorreo())
                .celular(tramite.getCelular())
                .direccion(tramite.getDireccion())
                .fechaRecepcion(Util.localDateToString(tramite.getFechaCreacion().toLocalDate()))
                .fechaVencimiento(Util.localDateToString(tramite.getFechaVencimiento()))
                .medioRecepcion(tramite.getTipoRecepcion().getDescripcion())
                .descripcion(tramite.getDescripcion())
                .build();
    }

    public static ListaTramiteResponse mapearListaTramiteResponse(Tramite tramite) {
        return ListaTramiteResponse.builder()
                .numeroVU(tramite.getNumeroVU())
                .asunto(tramite.getAsunto())
                .fechaRecepcion(Util.localDateToString(tramite.getFechaRecepcion()))
                .fechaVencimiento(Util.localDateToString(tramite.getFechaVencimiento()))
                .descripcionTipoTramite(tramite.getTipoTramite().getDescripcion())
                .build();
    }
}
