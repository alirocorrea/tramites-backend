package com.unicauca.tramites.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Util {

    private Util() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static String getDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public static LocalDate stringToLocalDate(String fecha) {
        if(Util.isNotNull(fecha)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(fecha, formatter);
        }
        return null;
    }

    public static String localDateToString(LocalDate fecha) {
        if(Util.isNotNull(fecha)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return fecha.format(formatter);
        }
        return null;
    }

    public static boolean esFechaMenorIgualActual(LocalDate date) {
        return date.compareTo(LocalDate.now()) <= 0;
    }
}
