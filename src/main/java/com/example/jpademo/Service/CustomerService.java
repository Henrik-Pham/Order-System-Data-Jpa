package com.example.jpademo.Service;
import com.example.jpademo.customer.Customer;
import com.example.jpademo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public List<Customer> getCustomersPageable(int pageNumber){
        return customerRepo.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }
    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepo.deleteById(id);
    }

    public Customer updateCustomerName(Customer customer){
        Customer customerToUpdate = customerRepo.findById(customer.getCustomerId()).orElse(null);
        if(customerToUpdate != null){
            customerToUpdate.setCustomerName(customer.getCustomerName());
            return customerRepo.save(customerToUpdate);
        }
        return null;
    }
}

/**
 * @SpringBootTest good for integration test
 * WebMvcTest good for testing controller
 * DataJpaTest good for testing service

 * Restful API
 * Relationships
 * Flyway??
 * H2 Database
 * Data JPA
 * at least 4 different entities
 * Business logic
 * CI/CD
 * Github deployment
 * Wiseflow (link to repo, link to running code)
 * Test, Integration test, service test, unit test
 * **/