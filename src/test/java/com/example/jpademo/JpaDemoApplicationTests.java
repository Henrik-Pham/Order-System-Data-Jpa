package com.example.jpademo;

import com.example.jpademo.Item.Item;
import com.example.jpademo.address.Address;
import com.example.jpademo.customer.Customer;
import com.example.jpademo.Item.Item;
import com.example.jpademo.order.Order;
import com.example.jpademo.repository.AddressRepo;
import com.example.jpademo.repository.CustomerRepo;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JpaDemoApplicationTests {

    private Order getOrders() {
        return new Order();
    }

    private Item getItem(String name, Integer qty) {
        return new Item(name, qty);
    }

    private final Faker faker = new Faker();

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AddressRepo addressRepo;

    @Test
    @org.junit.jupiter.api.Order(1)
    void testCustomerOrdersAndItems() {

        Customer customer = new Customer("Joe Bob Briggs", "joe@thedrivein.com");

        Order order1 = getOrders();
        Item wheel = getItem("wheel", 3);
        Item gear = getItem("gear", 10);
        order1.getItems().add(wheel);
        order1.getItems().add(gear);

        Order order2 = getOrders();
        Item piston = getItem("piston", 5);
        Item cog = getItem("cog", 29);
        order2.getItems().add(piston);
        order2.getItems().add(cog);

        //customer.getOrders().add(order1);
        //customer.getOrders().add(order2);
        Customer c = customerRepo.save(customer);
        assert c.getOrders().size() == 2;
        assert c.getOrders().get(0).getItems().size() == 2;

    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void testAddresses() {
        Address shippingAddress = new Address("123 Street Place");
        Address billingAddress = new Address("999 Uptown Blvd");
        Address a1 = addressRepo.save(shippingAddress);
        Address a2 = addressRepo.save(billingAddress);

        assert a1.getAddressText().contains("123 Street Place");
        assert a2.getAddressText().contains("999 Uptown Blvd");
    }

    @Test
    @Transactional
    @org.junit.jupiter.api.Order(3)
    void testAddingAddressesToCustomers() {
        Customer joeBob = customerRepo.save(new Customer(faker.name().fullName(), faker.internet().emailAddress()));
        Address shippingAddress = addressRepo.findById(1L).orElse(null);
        Address billingAddress = addressRepo.findById(2L).orElse(null);
        joeBob.getAddresses().add(shippingAddress);
        joeBob.getAddresses().add(billingAddress);
        Customer c1 = customerRepo.save(joeBob);
        for (Address address: c1.getAddresses()) {
            System.out.println(address.getAddressText());
        }
        assert c1.getAddresses().size() == 2;
    }

    @Test
    @Transactional
    @org.junit.jupiter.api.Order(4)
    void addressThing() {
        addressRepo.findById(1L).ifPresent(address -> address.getCustomers().forEach(customer -> System.out.println(customer.getCustomerName())));
    }
}

// Customer  0..*  Orders  1..*  Item
//            ^^            ^^
//     bidirectional   Unidirectional


/**
 * Customer 0..* Orders bidirectional
    @OneToMany
    List<Order>

 * Orders 1..* Items unidirectional
   @OneToMany
   List<Item>
   @ManyToOne
   Customer

 * Item
 */