package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatalogoReponse {

    private Long id;
    private String descripcion;
}
