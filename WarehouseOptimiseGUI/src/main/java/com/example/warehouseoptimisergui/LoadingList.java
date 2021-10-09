package com.example.warehouseoptimisergui;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadingList {
    private int warehouseIndex;
    private ArrayList<Loading> loadings;
    private Schedule loadSchedule;
    private static final int LOADBAY = 5;

    public LoadingList(int warehouseIndex) {
        this.warehouseIndex = warehouseIndex;
        loadings = new ArrayList<Loading>(
                Arrays.asList(new Loading(warehouseIndex),
                        new Loading(warehouseIndex),
                        new Loading(warehouseIndex),
                        new Loading(warehouseIndex),
                        new Loading(warehouseIndex)));
        loadSchedule = new Schedule(warehouseIndex, Task.LOAD);
    }

    public Schedule getLoadSchedule() {
        return loadSchedule;
    }

    public void addToSchedule(Container container) {
        loadSchedule.addSlot(container);
    }

    public void sortLoadingListByStartTime() {
        loadSchedule.sortByStartTime();
        assignLoadByTime();
    }

    public void assignLoadByTime() {
        ArrayList<Container> loadContainers = loadSchedule.getBookings();
        int minIndex = Math.min(loadSchedule.getBookings().size(), LOADBAY);
        for (int i = 0; i < minIndex; i++) {
            loadings.get(i).addSlot(loadSchedule.getSpecificBooking(i));
        }
        for (int j = LOADBAY; j < loadContainers.size(); j++) {
            Container specificBooking = loadSchedule.getSpecificBooking(j);
            Loading maxLoading = loadings.get(0);
            long maxTimeDiff = 0;
            for (Loading loading : loadings) {
                long timeDiff = ChronoUnit.MINUTES.between(loading.getLastContainer().getBookingEndTime(),
                        specificBooking.getBookingStartTime());
                if (timeDiff > maxTimeDiff) {
                    maxTimeDiff = timeDiff;
                    maxLoading = loading;
                }
            }
            maxLoading.addSlot(specificBooking);
        }
        for (Loading loading : loadings) {
            System.out.println(loading.getLoadBaySchedule());
        }
    }
}
