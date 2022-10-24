package com.unicauca.tramites.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private Integer status;
    private String error;
    private String message;
}
