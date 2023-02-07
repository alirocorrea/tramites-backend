package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPrueba {
    String fechaInicial;
    String fechafinal;
}
