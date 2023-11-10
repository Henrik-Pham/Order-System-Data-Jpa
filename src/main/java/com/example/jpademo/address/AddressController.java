package com.example.jpademo.address;
import com.example.jpademo.Service.AddressService;
import com.example.jpademo.Service.CustomerService;
import com.example.jpademo.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;
    private final CustomerService customerService;

    @Autowired
    public AddressController(AddressService addressService, CustomerService customerService) {
        this.addressService = addressService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Address> getAddresses(){
        return addressService.getAddress();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    public Address addNewAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PostMapping("/customer/{id}")
    public void addNewAddressToCustomer(@PathVariable Long id, @RequestBody Address address){
        Address newAddress = addressService.addAddress(address);
        Customer customer = customerService.getCustomerById(id);
        customer.getAddresses().add(newAddress);
        customerService.addCustomer(customer);
    }
}
