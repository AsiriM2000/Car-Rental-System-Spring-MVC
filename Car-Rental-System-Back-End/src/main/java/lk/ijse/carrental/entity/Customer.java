package lk.ijse.carrental.entity;


import lk.ijse.carrental.dto.CustomerVerificationImgDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
