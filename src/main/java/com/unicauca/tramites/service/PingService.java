package com.unicauca.tramites.service;

import com.unicauca.tramites.dto.PingResponse;

public interface PingService {

    PingResponse getPingMessageServer();

    PingResponse getPingMessageDB();
}
