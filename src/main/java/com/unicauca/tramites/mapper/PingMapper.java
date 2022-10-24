package com.unicauca.tramites.mapper;

import com.unicauca.tramites.dto.PingDTO;
import com.unicauca.tramites.common.Constants;
import com.unicauca.tramites.common.Util;

public final class PingMapper {

    private PingMapper() {
        throw new IllegalStateException(Constants.NOT_CREATE_OBJECT);
    }

    public static PingDTO buildDTO(String message) {
        return PingDTO.builder().message(message).date(Util.getDateTimeString()).build();
    }
}
