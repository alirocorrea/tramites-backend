package com.unicauca.tramites.exception;

import com.unicauca.tramites.dto.ExceptionResponse;
import com.unicauca.tramites.mapper.ExceptionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handleResponseException(ApplicationException ex, WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.buildDTO(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
