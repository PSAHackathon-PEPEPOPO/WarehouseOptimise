package com.example.warehouseoptimisergui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Parser {
    public Parser() {

    }

    LocalDateTime convertDateTime(String rawDateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy HH:mm");
        return LocalDateTime.parse(rawDateTime, formatter);
    }



}
