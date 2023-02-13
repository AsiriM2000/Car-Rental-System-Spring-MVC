package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    private String custEmail;
    private String custName;
    private String custAddress;
    private String custContactNumber;
    private String custNIC;
    private String custDrivingLicien;
    private String password;
}
