package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TramiteResponse implements Serializable {
    private Long id;
}
