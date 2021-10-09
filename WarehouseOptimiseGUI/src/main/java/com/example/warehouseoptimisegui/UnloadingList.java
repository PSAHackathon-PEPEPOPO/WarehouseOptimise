package com.example.warehouseoptimisegui;

import java.util.SortedMap;
import java.util.TreeMap;

public class UnloadingList {
    private static SortedMap<Unloading, Integer> unloadings;

    public UnloadingList() {
        unloadings = new TreeMap<Unloading, Integer>();
    }

    public void add(Unloading unloading, int warehouseIndex) {
        unloadings.put(unloading, warehouseIndex);
    }
}