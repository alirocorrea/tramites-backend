package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrazaResponse {
    private Long numeroVU;
    private String dependencia;
    private String numeroOficio;
    private String descripcion;
    private String fechaCreacion;
    private String fechaVencimiento;
    private boolean activo;
}
