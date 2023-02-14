package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {

    private String email;
    private String name;
    private String address;
    private String nic;
    private String license;
    private String contact;
    private String password;

}
