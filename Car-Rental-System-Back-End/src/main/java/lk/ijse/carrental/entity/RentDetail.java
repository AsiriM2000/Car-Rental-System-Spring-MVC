package lk.ijse.carrental.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetail {

 @Id
    private String rentId;
    private String date;
    private String regNumber;
    private String pickUpDate;
    private String returnDate;
    private String status;


}
