package com.example.warehouseoptimisergui;

public class Container {
    private int warehouseIndex;
    private String containerSerial;
    private Status status = Status.AVAIL;

    public Container(String containerSerial, int warehouseIndex) {
        this.warehouseIndex = warehouseIndex;
        this.containerSerial = containerSerial;
    }

    public int getWarehouseIndex() {
        return warehouseIndex;
    }

    @Override
    public String toString() {
        return "Container{" +
                "containerSerial='" + containerSerial + '\'' +
                ", status=" + status +
                '}';
    }
}
