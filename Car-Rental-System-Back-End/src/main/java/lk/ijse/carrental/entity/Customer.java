package lk.ijse.carrental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {

    @Id
    private String custEmail;
    private String custName;
    private String custAddress;
    private String custNIC;
    private String custDrivingLicien;
    private String custContactNumber;
    private String password;
}
