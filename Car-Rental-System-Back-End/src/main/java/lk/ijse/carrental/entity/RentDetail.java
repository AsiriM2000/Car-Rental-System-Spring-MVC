package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDetail{
    @Id
    private String rentId;
    private String date;
    private String pickUpDate;
    private String returnDate;
    private String status;
    private String email;
    private String regNumber;
    private String driverEmail;
//    @ManyToOne
//    @JoinColumn(name = "email",referencedColumnName = "email")
//    private Customer email;
//    @ManyToOne
//    @JoinColumn(name = "regNumber",referencedColumnName = "regNumber")
//    private Car regNumber;
//    @ManyToOne
//    @JoinColumn(name = "driverEmail",referencedColumnName = "driverEmail")
//    private Driver driverEmail;

}
