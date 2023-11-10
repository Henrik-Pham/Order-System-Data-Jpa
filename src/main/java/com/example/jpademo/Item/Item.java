package com.example.jpademo.Item;

import com.example.jpademo.order.CustomerOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item{

    @Id
    @GeneratedValue(generator = "item_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "item_seq", allocationSize = 1)

    @Column(name = "item_id")
    private Long itemId = 0L;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_quantity")
    private double itemQuantity;

    public Item(String itemName, double itemQuantity) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }
}
