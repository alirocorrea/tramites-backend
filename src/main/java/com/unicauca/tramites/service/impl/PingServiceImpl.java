package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.domain.Configuraciones;
import com.unicauca.tramites.dto.PingDTO;
import com.unicauca.tramites.mapper.PingMapper;
import com.unicauca.tramites.repository.ConfiguracionesRepository;
import com.unicauca.tramites.service.PingService;
import com.unicauca.tramites.common.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PingServiceImpl implements PingService {

    private ConfiguracionesRepository  configuracionesRepository;

    @Override
    public PingDTO getPingMessageServer() {
        return PingMapper.buildDTO(Constants.SERVER_PING_MESSAGE);
    }

    @Override
    public PingDTO getPingMessageDB() {
        Configuraciones configuraciones = configuracionesRepository.findById(1L).orElse(null);
        if(configuraciones != null && configuraciones.getMensajePing() != null) {
          return PingMapper.buildDTO(configuraciones.getMensajePing());
        }
        return null;
    }
}
