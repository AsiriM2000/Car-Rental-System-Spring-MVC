package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {

    private String driverEmail;
    private String driverName;
    private String driverAddress;
    private String driverAge;
    private String driverContact;
}
