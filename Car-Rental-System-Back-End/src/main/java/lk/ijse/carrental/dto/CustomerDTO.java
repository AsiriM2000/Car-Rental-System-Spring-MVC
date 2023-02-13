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

    private String custEmail;
    private String custName;
    private String custAddress;
    private String custNIC;
    private String custDrivingLicien;
    private String custContactNumber;
    private String password;

}
