package com.unicauca.tramites.mapper;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.dto.ErrorResponse;

public final class ErrorMapper {

    private ErrorMapper() {
        throw new IllegalStateException(Constants.NOT_CREATE_OBJECT);
    }

    public static ErrorResponse buildDTO(String message) {
        return ErrorResponse.builder()
                .status(Constants.APPLICATION_EXCEPTION_STATUS)
                .error(Constants.APPLICATION_EXCEPTION_MESSAGE)
                .message(message)
                .build();
    }
}
