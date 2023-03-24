package in.address.service.addressService.service;

import in.address.service.addressService.domain.Address;

import java.util.List;

public interface IAddress {

    Address saveAddress(Address address);

    List<Address> allAddress();

    List<Address> userAddress(String userId);

    Address getById(String Id);


}
