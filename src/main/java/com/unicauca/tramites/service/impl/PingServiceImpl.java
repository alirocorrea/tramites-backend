package com.unicauca.tramites.service.impl;

import com.unicauca.tramites.domain.Configuraciones;
import com.unicauca.tramites.dto.PingResponse;
import com.unicauca.tramites.exception.ApplicationException;
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
    public PingResponse getPingMessageServer() {
        return PingMapper.buildDTO(Constants.SERVER_PING_MESSAGE);
    }

    @Override
    public PingResponse getPingMessageDB() {
        Configuraciones configuraciones = configuracionesRepository.findById(1L).orElse(null);
        if(configuraciones == null) {
            throw new ApplicationException("No se encontró el registro de configuración");
        }
        return PingMapper.buildDTO(configuraciones.getMensajePing());
    }
}
