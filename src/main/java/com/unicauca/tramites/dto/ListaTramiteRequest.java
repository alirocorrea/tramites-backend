package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListaTramiteRequest {

    private Long numeroVU;
    private Long idTipoTramite;
}
