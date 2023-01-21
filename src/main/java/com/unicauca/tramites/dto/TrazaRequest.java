package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrazaRequest {

    private Long numeroVU;
    private Long idDependencia;
    private String numeroOficio;
    private String descripcion;

}
