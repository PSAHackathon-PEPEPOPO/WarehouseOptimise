package com.example.warehouseoptimisergui;

import java.util.SortedMap;
import java.util.TreeMap;

public class LoadingList {
    private static SortedMap<Loading, Integer> loadings;

    public LoadingList() {
        loadings = new TreeMap<Loading, Integer>();
    }

    public void add(Loading loading, int warehouseIndex) {
        loadings.put(loading, warehouseIndex);
    }
}
