package in.address.service.addressService.service;

import in.address.service.addressService.domain.Address;
import in.address.service.addressService.exception.ResourceNotFoundException;
import in.address.service.addressService.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements IAddress {

    @Autowired
    private AddressRepository repository;

    @Override
    public Address saveAddress(Address address) {
        address.setUserId(UUID.randomUUID().toString());
        return this.repository.save(address);
    }

    @Override
    public List<Address> allAddress() {
        return this.repository.findAll();
    }

    @Override
    public List<Address> userAddress(String userId) {
        return null;
    }

    @Override
    public Address getById(String addressId) {
        return this.repository.findById(addressId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with this id : " + addressId));
    }
}
