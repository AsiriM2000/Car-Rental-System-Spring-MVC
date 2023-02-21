package lk.ijse.carrental.entity;


import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
