package com.example.jpademo.Item;

import com.example.jpademo.customer.Customer;
import com.example.jpademo.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(generator = "item_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "item_seq", allocationSize = 1)
    private Long itemId;
    private String itemName;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders;

    public Item(String itemName) {
        this.itemName = itemName;
    }
}
