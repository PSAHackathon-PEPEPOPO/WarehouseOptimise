package com.example.warehouseoptimisegui;

import java.util.SortedMap;
import java.util.TreeMap;

public class LoadingList {
    private static SortedMap<Loading, Integer> loadings;

    public LoadingList() {
        loadings = new TreeMap<Loading, Integer>();
    }
}
