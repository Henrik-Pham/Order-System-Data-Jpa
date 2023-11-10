package com.example.jpademo.address;
import com.example.jpademo.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(generator = "address_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "address_seq_gen", sequenceName = "address_seq", allocationSize = 1)

    @Column(name = "address_id")
    private Long addressId = 0L;

    @Column(name = "address_text")
    private String addressText;

    @ManyToMany(mappedBy = "addresses", cascade =  CascadeType.ALL)
    @JsonIgnore
    private List<Customer> customers = new ArrayList<>();

    public Address(String addressText) {
        this.addressText = addressText;
    }
}
