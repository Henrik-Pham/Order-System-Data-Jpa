package com.example.jpademo.Service;
import com.example.jpademo.address.Address;
import com.example.jpademo.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepo addressRepository;

    @Autowired
    public AddressService(AddressRepo addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address){
        return addressRepository.save(address);
    }

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    /**
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }
     **/

    public Address getAddressById(Long id){
        return addressRepository.findById(id).orElse(null);
    }

}
