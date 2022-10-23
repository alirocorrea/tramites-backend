package com.unicauca.tramites.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Util {

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static String getDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
