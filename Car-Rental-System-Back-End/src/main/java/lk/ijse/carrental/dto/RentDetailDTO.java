package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetailDTO {

    private String rentId;
    private LocalDate date;
    private String regNumber;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String status;
}
