package com.example.warehouseoptimisergui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Parser {
    public Parser() {

    }

    static LocalDateTime convertDateTime(String rawDateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy HH:mm");
        return LocalDateTime.parse(rawDateTime, formatter);
    }

    public static LocalDateTime getHour(String hourString, LocalDateTime dayTime) {
        String[] splitStringByRegex = hourString.split(":", 2);
        String hour = splitStringByRegex[0];
        int hourInt = Integer.parseInt(hour);
        LocalDateTime updatedDateTime = dayTime.withHour(hourInt);
        return updatedDateTime;
    }
}
