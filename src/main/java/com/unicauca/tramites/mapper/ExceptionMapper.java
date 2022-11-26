package com.unicauca.tramites.mapper;

import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.dto.ExceptionResponse;

public final class ExceptionMapper {

    private ExceptionMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ExceptionResponse buildDTO(String message) {
        return ExceptionResponse.builder()
                .status(Constants.APPLICATION_EXCEPTION_STATUS)
                .error(Constants.APPLICATION_EXCEPTION_MESSAGE)
                .message(message)
                .build();
    }
}
