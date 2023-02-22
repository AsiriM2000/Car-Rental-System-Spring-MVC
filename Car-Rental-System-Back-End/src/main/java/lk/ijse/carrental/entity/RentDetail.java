package lk.ijse.carrental.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RentDetail{
    @Id
    private String rentId;
    private String email;
    private String date;
    private String regNumber;
    private String pickUpDate;
    private String returnDate;
    private String status;


}
