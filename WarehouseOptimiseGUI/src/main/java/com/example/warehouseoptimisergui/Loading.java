package com.example.warehouseoptimisergui;

import java.util.ArrayList;

public class Loading {
    private Status status;
    private Schedule loadBaySchedule;

    public Loading(int warehouseIndex) {
        this.loadBaySchedule = new Schedule(warehouseIndex, Task.LOAD);
        this.status = Status.AVAIL;
    }

    public Schedule getLoadBaySchedule() {
        return loadBaySchedule;
    }

    public void addSlot(Container container) {
        loadBaySchedule.addSlot(container);
    }

    public Container getLastContainer() {
        ArrayList<Container> containers = loadBaySchedule.getBookings();
        return containers.get(containers.size() - 1);
    }

}
