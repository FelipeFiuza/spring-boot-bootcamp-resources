package com.ltp.globalsuperstore.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.StoreRepository;

public class StoreService {
    
    StoreRepository storeRepository = new StoreRepository();

    public Item getItem(int index) {
        return storeRepository.get(index);
    }

    public void setItem(int index, Item item) {
        storeRepository.set(index, item);
    }

    public void addItem(Item item) {
        storeRepository.add(item);
    }

    public List<Item> getItems(){
        return storeRepository.getItems();
    }

    public int getIndexFromId(String id) {
        for (int i = 0; i < getItems().size(); i++) {
            if (getItem(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    public String submitItem(Item item) {
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            addItem(item);
        } else if (within5Days(item.getDate(), getItem(index).getDate())) {
            setItem(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }

        return status;
    }

    public boolean isPriceLessThanDiscount(Item item) {
        return item.getPrice() < item.getDiscount();
    }

    public Item getItemById(String id) {
        return getIndexFromId(id) == Constants.NOT_FOUND ? new Item() : getItem(getIndexFromId(id));
    }

}
