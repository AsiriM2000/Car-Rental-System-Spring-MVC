package lk.ijse.carrental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    private String email;
    private String nic;
    private String name;
    private String address;
    private String license;
    private String contact;
    private String password;
    private String imageLocation;
}
