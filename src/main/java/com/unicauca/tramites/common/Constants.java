package com.unicauca.tramites.common;


public final class Constants {
    private Constants() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    //SWAGGER
    public static final String SWAGGER_TITLE = "API Trámites PQRSF Backend";
    public static final String SWAGGER_DESCRIPTION = "Servicios REST para el proyecto de trámites PQRSF de la Universidad del Cauca";
    public static final String SWAGGER_VERSION = "v0.0.1";

    //GENERAL
    public static final String UTILITY_CLASS = "Utility class";
    public static final String SERVER_PING_MESSAGE = "Conexión correcta con tramites-server";

    //EXCEPCIONES
    public static final Integer BAD_REQUEST_STATUS = 400;
    public static final String APPLICATION_EXCEPTION = "Application Exception";
    public static final String DATA_EXCEPTION = "Data Exception";
    public static final String CONSTRAINT_VIOLATION_EXCEPTION = "Constraint Violation Exception";

    //MENSAJES
    public static final String FECHA_INVALIDA = "Fecha de registro superior a la fecha actual";
    public static final String ID_TIPO_TRAMITE_INVALIDO = "ID del tipo tramite invalido";
    public static final String ID_TIPO_RECEPCION_INVALIDO = "ID del tipo recepcion invalido";
    public static final String ID_DEPENDENCIA_INVALIDO = "ID de la dependencia invalido";
    public static final String ERROR_OBTENIENDO_CONFIGURACION_DB = "No se encontró la configuración en la db";

    public static final String ERROR_TIPO_PETICIONARIO = "ID del tipo peticionario invalido";
    public static final String ERROR_NUMERO_VU = "El numero de ventanilla única ya se encuentra registrado";
    public static final String ERROR_NUMERO_VU_NO_EXISTE = "El numero de ventanilla única no existe";

    public static final String ERROR_ID_TRAMITE = "EL ID del tramite no existe";

    public static final String ERROR_TRAZABILIDAD_NULA = "No existe trazabilidad";
}
