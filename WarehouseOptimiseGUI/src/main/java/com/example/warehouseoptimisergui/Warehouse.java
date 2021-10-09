package com.example.warehouseoptimisergui;

public class Warehouse {
    private int index;
    private LoadingList loadings;
    private UnloadingList unloadings;

    public Warehouse(int index) {
        this.index = index;
        loadings = new LoadingList();
        unloadings = new UnloadingList();
    }
}
