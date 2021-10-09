package com.example.warehouseoptimisergui;

import java.util.HashMap;
import java.util.TreeMap;

public class ContainerList {
    private static HashMap<Container, Integer> containers;

    public ContainerList() {
        containers = new HashMap<>();
    }

    public HashMap<Container,Integer> getContainers() {
        return containers;
    }

    public void add(Container container) {
        int warehouseIndex = container.getWarehouseIndex();
        containers.put(container, warehouseIndex);
    }
}
