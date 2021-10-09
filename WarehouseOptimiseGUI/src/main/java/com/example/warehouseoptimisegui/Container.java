package com.example.warehouseoptimisergui;

public class Container {
    private int warehouseIndex;
    private Status status = Status.AVAIL;

    public void Container(int warehouseIndex) {
        this.warehouseIndex = warehouseIndex;
    }

    public int getWarehouseIndex() {
        return warehouseIndex;
    }
}
