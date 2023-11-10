package com.example.jpademo;
import com.example.jpademo.Service.AddressService;
import com.example.jpademo.Service.CustomerService;
import com.example.jpademo.address.Address;
import com.example.jpademo.customer.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerAddressTest {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @DisplayName("Checks if jim bob has more than one address")
    @Test
    void customerShouldOnlyHaveOneAddress() {
        Customer jimBob = new Customer("Jim Bob", "jim@bob.com");
        Address jimAddress = new Address("123 Place street");
        Address saveAddress = addressService.addAddress(jimAddress);
        jimBob.getAddresses().add(saveAddress);
        Customer j = customerService.addCustomer(jimBob);

        assert j.getAddresses().size() == 1;
    }
}
