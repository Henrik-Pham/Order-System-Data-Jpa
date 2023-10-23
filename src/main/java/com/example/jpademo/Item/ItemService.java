package com.example.jpademo.Item;

import com.example.jpademo.customer.Customer;
import com.example.jpademo.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> getItems(){
        return itemRepo.findAll();
    }

    public Item getItemById(Long id){
        return itemRepo.findById(id).orElse(null);
    }

    public Item createItem(Item item){
        return itemRepo.save(item);
    }

    public Item updateItem(Item item){
        return itemRepo.save(item);
    }

    public void deleteItem (Long id){
        itemRepo.deleteById(id);
    }

}

/**
 * Ordering system
 * Have an item table where items can be stored
 * A place to put the people who buy things
 * A place to put the things that can be bought
 * A place for orders
 * **/