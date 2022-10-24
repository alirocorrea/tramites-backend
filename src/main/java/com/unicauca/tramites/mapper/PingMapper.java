package com.unicauca.tramites.mapper;

import com.unicauca.tramites.dto.PingResponse;
import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;

public final class PingMapper {

    private PingMapper() {
        throw new IllegalStateException(Constants.NOT_CREATE_OBJECT);
    }

    public static PingResponse buildDTO(String message) {
        return PingResponse.builder()
                .message(message)
                .date(Util.getDateTimeString())
                .build();
    }
}
