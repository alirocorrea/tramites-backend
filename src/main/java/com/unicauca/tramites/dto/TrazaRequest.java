package com.unicauca.tramites.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrazaRequest {

    private Long numeroVU;
    private Long idDependencia;
    private String numeroOficio;
    private String descripcion;

}
