package com.example.jpademo.customer;
import com.example.jpademo.address.Address;
import com.example.jpademo.order.CustomerOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity // Mapping to a table
@Getter
@Setter
@ToString
@NoArgsConstructor
//@Table(name = "distribution_unit")
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq", allocationSize = 1)

    @Column(name = "customer_id")
    private Long customerId = 0L;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_customer_id")
    private List<CustomerOrder> orders = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses = new ArrayList<>();

    public Customer(Long customerId, String customerName, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public Customer(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }
}
