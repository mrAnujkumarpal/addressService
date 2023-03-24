package in.address.service.addressService.controller;

import in.address.service.addressService.domain.Address;
import in.address.service.addressService.service.IAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddress addressService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Have a nice day !!...";
    }

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address createdAddress = this.addressService.saveAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Address>> allAddress() {

        List<Address> addressList = addressService.allAddress();

        return ResponseEntity.ok(addressList);
    }

    @GetMapping("/{addressId}/view")
    public ResponseEntity<Address> addressById(@PathVariable String addressId) {

        return ResponseEntity.ok(this.addressService.getById(addressId));
    }

}
