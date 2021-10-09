package com.example.warehouseoptimisergui;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Container {
    private int warehouseIndex;
    private String containerSerial;
    private Status status = Status.AVAIL;
    private LocalDateTime date;
    private Task task;
    private LocalDateTime bookingStartTime;
    private LocalDateTime bookingEndTime;

    private Parser parser = new Parser();

    public Container(String containerSerial, int warehouseIndex, String rawDate, Task task) {
        this.warehouseIndex = warehouseIndex;
        this.containerSerial = containerSerial;
        date = parser.convertDateTime(rawDate);
        this.task = task;
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

    public static Comparator<Container> SlotTimeComparator = new Comparator<Container>() {
        public int compare(Container c1, Container c2) {
            LocalDateTime c1EndTime = c1.getBookingEndTime();
            LocalDateTime c2StartTime = c2.getBookingStartTime();
            return c1EndTime.compareTo(c2StartTime);
        }
    };

    @Override
    public String toString() {
        return "Container{" +
                "containerSerial='" + containerSerial + '\'' +
                ", status=" + status + '\'' +
                ", bookingStartTime=" + bookingStartTime.toString() + '\'' +
                ", bookingEndTime=" + bookingEndTime.toString() +
                '}';
    }
}
