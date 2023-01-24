package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TramiteResponse {

    private Long id;
    private String tipoPQRSF;
    private String Asunto;
    private String peticionario;
    private String tipoPeticionario;
    private String numeroOficio;
    private String dependencia;
    private String email;
    private String celular;
    private String direccion;
    private String fechaRecepcion;
    private String fechaVencimiento;
    private String medioRecepcion;
    private String descripcion;
    private List<TrazaResponse> traza;


}
