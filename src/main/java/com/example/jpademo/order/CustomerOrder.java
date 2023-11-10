package com.example.jpademo.order;
import com.example.jpademo.Item.Item;
import com.example.jpademo.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class CustomerOrder {



    @Id
    @GeneratedValue(generator = "customer_order_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_order_seq_gen", sequenceName = "customer_order_seq", allocationSize = 1)

    @Column(name = "customer_order_id")
    private Long customerOrderId = 0L;

    @Column(name = "customer_order_date")
    private LocalDateTime customerOrderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("customer_orders")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_order_id")
    private List<Item> items = new ArrayList<>();

    public CustomerOrder(LocalDateTime customerOrderDate) {
        this.customerOrderDate = customerOrderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
