package com.example.warehouseoptimisergui;

import java.util.ArrayList;
import java.util.Collections;

public class Schedule {
    private ArrayList<Container> bookings;
    private int warehouseIndex;
    private Task task;

    public Schedule(int warehouseIndex, Task task) {
        this.warehouseIndex = warehouseIndex;
        this.task = task;
        this.bookings = new ArrayList<>();
    }

    public ArrayList<Container> getBookings() {
        return bookings;
    }

    public Container getSpecificBooking(int bookingIndex) {
        return bookings.get(bookingIndex);
    }

    public void addSlot(Container container) {
        bookings.add(container);
    }

    public void sortByStartTime() {
        Collections.sort(bookings, Container.StartTimeComparator);
    }

    private String list() {
        StringBuilder listedBookings = new StringBuilder();
        for (Container booking : bookings) {
            listedBookings.append(booking.getBookingStartTime().toString());
            listedBookings.append(booking.getBookingEndTime().toString() + "\n");
        }
        return listedBookings.toString();
    }

    @Override
    public String toString() {
        return "Schedule" +
                "warehouseIndex=" + warehouseIndex +
                ", task=" + task + "\n"
                + list();
    }
}
