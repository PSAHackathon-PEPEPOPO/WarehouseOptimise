package com.example.warehouseoptimisergui;

public class Warehouse {
    private int index;
    private LoadingList loadings;
    private UnloadingList unloadings;

    public Warehouse(int index) {
        this.index = index;
        loadings = new LoadingList(index);
        unloadings = new UnloadingList(index);
    }

    public int getIndex() {
        return index;
    }

    public Schedule getLoadings() {
        return loadings.getLoadSchedule();
    }

    public Schedule getUnloadings() {
        return unloadings.getUnloadSchedule();
    }

    public void sortLoadingsByStartTime() {
        loadings.sortLoadingListByStartTime();
    }

    public void sortUnloadingsByStartTime() {
        unloadings.sortUnloadingListByStartTime();
    }

    public void addToSchedule(Container container) {
        if (container.getTask().equals(Task.LOAD)) {
            loadings.addToSchedule(container);
        } else {
            unloadings.addToSchedule(container);
        }
    }
}
