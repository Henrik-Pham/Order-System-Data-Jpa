package com.example.jpademo.customer;

import com.example.jpademo.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Entity // Mapping to a table
@Setter
@NoArgsConstructor
//@Table(name = "distribution_unit")
public class Customer {


    @Id
    @GeneratedValue(generator = "customer_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq", allocationSize = 1)
    private Long customerId;

    private String customerName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(String customerName) {
        this.customerName = customerName;
    }
}
