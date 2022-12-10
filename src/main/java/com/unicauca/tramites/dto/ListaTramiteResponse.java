package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaTramiteResponse {

    private Long numeroVU;
    private String asunto;
    private String fechaRecepcion;
    private String fechaVencimiento;
    private String descripcionTipoTramite;
}
