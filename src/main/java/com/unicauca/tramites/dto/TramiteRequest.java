package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TramiteRequest {

    private String nombrePeticionario;
    private Long idTipoTramite;
    private String correo;
    private Long numeroVU;
    private String celular;
    private String fechaRecepcion;
    private String telefono;
    private String direccion;
    private String asunto;
    private String numeroOficio;
    private Long idDependencia;
    private Long idTipoRecepcion;
    private String descripcion;
}
