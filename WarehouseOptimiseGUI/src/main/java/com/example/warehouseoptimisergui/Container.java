package com.example.warehouseoptimisergui;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Container {
    private int warehouseIndex;
    private String containerSerial;
    private LocalDateTime date;
    private Task task;
    private LocalDateTime bookingStartTime;
    private LocalDateTime bookingEndTime;

    private Parser parser = new Parser();

    public Container(String containerSerial, int warehouseIndex, LocalDateTime date, Task task) {
        this.warehouseIndex = warehouseIndex;
        this.containerSerial = containerSerial;
        this.date = date;
        this.task = task;
        bookingStartTime = LocalDateTime.now();
        bookingEndTime = LocalDateTime.now();

    }

    public void addBookingTime(LocalDateTime bookingStartTime, LocalDateTime bookingEndTime) {
        this.bookingStartTime = bookingStartTime;
        this.bookingEndTime = bookingEndTime;
    }

    public int getWarehouseIndex() {
        return warehouseIndex;
    }

    public String getContainerSerial() {
        return containerSerial;
    }

    public Task getTask() {
        return task;
    }

    public LocalDateTime getBookingStartTime() {
        return bookingStartTime;
    }

    public LocalDateTime getBookingEndTime() {
        return bookingEndTime;
    }

    public static Comparator<Container> StartTimeComparator = new Comparator<Container>() {
        public int compare(Container c1, Container c2) {
            LocalDateTime c1StartTime = c1.getBookingStartTime();
            LocalDateTime c2StartTime = c2.getBookingStartTime();
            return c1StartTime.compareTo(c2StartTime);
        }
    };

    @Override
    public String toString() {
        return "Container{" +
                "containerSerial='" + containerSerial + '\'' +
                "Task=" + task + '\'' +
                ", bookingStartTime=" + bookingStartTime.toString() + '\'' +
                ", bookingEndTime=" + bookingEndTime.toString() +
                '}';
    }

    public String toInfoString() {
        return "ContainerSerial: " + containerSerial + " ," +
                "Warehouse: " + warehouseIndex + "," +
                "Task: " + task;
    }
}
