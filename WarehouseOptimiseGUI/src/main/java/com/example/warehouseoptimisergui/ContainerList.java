package com.example.warehouseoptimisergui;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ContainerList {
    private static HashMap<Container, Warehouse> containers = new HashMap<>();
    private final static Parser parser = new Parser();

    public ContainerList() {
        containers = new HashMap<>();
    }

    public HashMap<Container, Warehouse> getContainers() {
        return containers;
    }

    public void addBookingTime(String containerSerial, String rawStartTime, String rawEndTime) {
        LocalDateTime startTime = parser.convertDateTime(rawStartTime);
        LocalDateTime endTime = parser.convertDateTime(rawEndTime);
        for (Map.Entry<Container, Warehouse> container : containers.entrySet()) {
            if (containerSerial.equals(container.getKey().getContainerSerial())) {
                Container curr = container.getKey();
                curr.addBookingTime(startTime, endTime);
                container.getValue().addToSchedule(curr);
            }
        }
    }

    public void add(Container container, Warehouse warehouse) {
        containers.put(container, warehouse);
    }
}
