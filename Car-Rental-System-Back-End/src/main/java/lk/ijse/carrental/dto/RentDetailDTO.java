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
    private String date;
    private String regNumber;
    private String pickUpDate;
    private String returnDate;
    private String status;
}
