package com.ltp.globalsuperstore.repository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.globalsuperstore.Item;

public class StoreRepository {
    
    List<Item> items = new ArrayList<>();

    public Item get(int index) {
        return items.get(index);
    }

    public void set(int index, Item item) {
        items.set(index, item);
    }

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

}
