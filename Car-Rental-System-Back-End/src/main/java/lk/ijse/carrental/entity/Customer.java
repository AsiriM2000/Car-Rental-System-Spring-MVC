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
public class Customer {

    @Id
    private String email;
    private String name;
    private String address;
    private String nic;
    private String license;
    private String contact;
    private String password;
}
