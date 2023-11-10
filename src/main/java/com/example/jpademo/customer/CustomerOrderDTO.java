package com.example.jpademo.customer;
import com.example.jpademo.Item.Item;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class CustomerOrderDTO {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
