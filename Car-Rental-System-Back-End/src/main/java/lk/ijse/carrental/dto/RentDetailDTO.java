package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetailDTO {

    private String rentId;
    private String email;
    private String date;
    private String pickUpDate;
    private String returnDate;
    private String status;
    private String regNumber;
    private String driverEmail;
    private String driveStatus;
    private String pickUpLocation;
    private String dropLocation;
}
