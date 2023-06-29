package lk.ijse.carrental.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String email;
    private String nic;
    private String name;
    private String address;
    private String license;
    private String contact;
    private String password;
    private String imageLocation;
}
