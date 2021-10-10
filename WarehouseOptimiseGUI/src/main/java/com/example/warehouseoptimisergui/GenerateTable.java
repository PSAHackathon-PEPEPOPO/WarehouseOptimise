package com.example.warehouseoptimisergui;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class GenerateTable {
    private LocalDateTime time;
    private LocalTime onlyTime;
    private String timeInString;
    private String availability;
    private static String[] avail1 = new String[12];

    public GenerateTable(String time) {
        this.time = Parser.convertDateTime(time);
        this.onlyTime = generateTime(this.time);
        this.timeInString = onlyTime.toString();
        this.availability = "yes";
        for (int i = 0; i < 12; i += 1) {
            avail1[i] = "yes";
        }
    }

    public LocalTime generateTime(LocalDateTime dateTime) {
        LocalTime time = dateTime.toLocalTime();
        return time;
    }

    public static void setAvail1(int i) {
        avail1[i] = "no";
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}