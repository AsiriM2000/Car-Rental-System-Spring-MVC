package lk.ijse.carrental.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetail {

 @Id
    private String rentId;
    private LocalDate date;
    private String regNumber;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String status;


}
