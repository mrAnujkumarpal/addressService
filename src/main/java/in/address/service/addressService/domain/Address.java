package in.address.service.addressService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    String addressId;
    String address;
    String city;
    String state;
    Integer pin;
    String userId;

}
