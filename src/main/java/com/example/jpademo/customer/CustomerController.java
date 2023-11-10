package com.example.jpademo.customer;
import com.example.jpademo.Item.Item;
import com.example.jpademo.Service.AddressService;
import com.example.jpademo.Service.CustomerService;
import com.example.jpademo.address.Address;
import com.example.jpademo.order.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final AddressService addressService;
    @Autowired
    public CustomerController(CustomerService customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping("/{id}")
    public Customer createOrderForCustomer(@PathVariable Long id, @RequestBody CustomerOrderDTO customerOrderDTO){
        Customer customer = customerService.getCustomerById(id);
        CustomerOrder order = new CustomerOrder();
        order.setCustomerOrderDate(LocalDateTime.now());
        for (Item item : customerOrderDTO.getItems()) {
            order.getItems().add(item);
        }
        customer.getOrders().add(order);
        return customerService.updateCustomer(customer);
    }

    @PutMapping("/{customerId}/address/{addressId}")
    public Customer updateCustomerAddAddresses(@PathVariable Long customerId, @PathVariable Long addressId, @RequestBody Address address){
        Customer c = customerService.getCustomerById(customerId);
        Address a = addressService.getAddressById(addressId);

        c.getAddresses().add(a);
        return customerService.updateCustomer(c);
    }

    @GetMapping("/page/{pageNumber}")
    public List<Customer> getCustomersByPage(@PathVariable int pageNumber) {
        return customerService.getCustomersPageable(pageNumber);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
