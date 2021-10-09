package com.example.warehouseoptimisergui;

public class Warehouse {
    private int index;
    private ContainerList containers;
    private LoadingList loadings;
    private UnloadingList unloadings;

    public Warehouse(int index, ContainerList containers) {
        this.index = index;
        this.containers = containers;
    }
}
