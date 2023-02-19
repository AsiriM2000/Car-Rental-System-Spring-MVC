package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDetail {

    @Id
    private String rentId;
    private LocalDate date;
    @Id
    private String regNumber;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "email",referencedColumnName = "email",insertable = false,updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "driverEmail",referencedColumnName = "driverEmail",insertable = false,updatable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "regNumber",referencedColumnName = "regNumber",insertable = false,updatable = false)
    private Car car;
}
