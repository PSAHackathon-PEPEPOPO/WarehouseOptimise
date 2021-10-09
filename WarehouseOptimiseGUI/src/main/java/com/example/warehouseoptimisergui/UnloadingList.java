package com.example.warehouseoptimisergui;

public class UnloadingList {
    private int warehouseIndex;
    private Unloading[] unloadings;
    private Schedule unloadSchedule;

    public UnloadingList(int warehouseIndex) {
        this.warehouseIndex = warehouseIndex;
        unloadings = new Unloading[5];
        unloadSchedule = new Schedule(warehouseIndex, Task.UNLOAD);
    }

    public void addToSchedule(Container container) {
        unloadSchedule.addSlot(container);
    }

    public Schedule getUnloadSchedule() {
        return unloadSchedule;
    }

    public void sortUnloadingListByStartTime() {
        unloadSchedule.sortByStartTime();
    }
}