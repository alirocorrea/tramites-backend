package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TramiteRequest implements Serializable {

    private String nombrePeticionario;
    private Long idTipoTramite;
    private String correo;
    private long numeroVU;
    private String celular;
    private String fechaRecepcion;
    private String telefono;
    private String direccion;
    private String asunto;
    private String numOficio;
    private Long idDependencia;
    private Long idTipoRecepcion;
    private String descripcion;
}
