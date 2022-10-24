package com.unicauca.tramites.common;


public final class Constants {
    private Constants() {
        throw new IllegalStateException(Constants.NOT_CREATE_OBJECT);
    }

    //SWAGGER
    public static final String SWAGGER_TITLE = "Trámites PQRSF Backend";
    public static final String SWAGGER_DESCRIPTION = "Documentación de servicios REST para el proyecto de trámites PQRSF";
    public static final String SWAGGER_VERSION = "v0.0.1";

    //GENERAL
    public static final String NOT_CREATE_OBJECT = "No se debe crear instancias de esta clase";
    public static final String SERVER_PING_MESSAGE = "Conexión exitosa con el servidor tramites-backend";

    //EXCEPCIONES
    public static final Integer APPLICATION_EXCEPTION_STATUS = 400;
    public static final String APPLICATION_EXCEPTION_MESSAGE = "Application Exception";
}
