package com.example.jpademo;
import com.example.jpademo.address.Address;
import com.example.jpademo.repository.AddressRepo;
import com.example.jpademo.customer.Customer;
import com.example.jpademo.repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

   /**
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepo customerRepo){
        return args -> {
            customerRepo.save(new Customer("Jim Bob Luke", "jimbob@luke.com"));
        };
    }
**/

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepo customerRepository,
            AddressRepo addressRepository) {
        return args -> {
            Customer c = customerRepository.save(new Customer("Joe Bob Briggs", "joe@joebob.com"));
            Address a = addressRepository.save(new Address("1234 Place Street, #3"));
            Address b = addressRepository.save(new Address("4321 Place Strees, #1"));
            c.getAddresses().add(a);
            c.getAddresses().add(b);
            customerRepository.save(c);
        };
    }
}
