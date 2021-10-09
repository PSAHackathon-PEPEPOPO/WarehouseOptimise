package com.example.warehouseoptimisergui;

import java.util.SortedMap;
import java.util.TreeMap;

public class ContainerList {
    private static SortedMap<Container, Integer> containers;

    public ContainerList() {
        containers = new TreeMap<>();
    }

    public void add(Container container) {
        int warehouseIndex = container.getWarehouseIndex();
        containers.put(container, warehouseIndex);
    }
}
