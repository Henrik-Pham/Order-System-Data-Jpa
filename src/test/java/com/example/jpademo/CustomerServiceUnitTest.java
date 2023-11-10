package com.example.jpademo;
import com.example.jpademo.Service.CustomerService;
import com.example.jpademo.customer.Customer;
import com.example.jpademo.repository.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceUnitTest {

    @MockBean
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerService customerService;

    @Test
    void shouldGetCustomers(){
        List<Customer> customerList = List.of(new Customer("Bob", "a@b.com"));
        Customer testCustomer = new Customer(1L, "Ted", "Ted@gmail.com");

        when(customerRepo.findAll()).thenReturn(customerList); /** When accessing and customerRepo and findAll, then return all customers **/
        when(customerRepo.save(testCustomer)).thenReturn(testCustomer);

        assert customerService.getCustomers().size() == 1;
        assert testCustomer.getCustomerEmail().equals("Ted@gmail.com");
    }
}
