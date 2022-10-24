package com.unicauca.tramites.service;

import com.unicauca.tramites.dto.PingDTO;

public interface PingService {

    PingDTO getPingMessageServer();
    PingDTO getPingMessageDB();
}
