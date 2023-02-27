package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private String carName;
    @Id
    private String regNumber;
    private String brand;
    private String type;
    private String noOfPassenger;
    private String transmission;
    private String fuelType;
    private String dailyRate;
    private String monthlyRate;
    private String freePrice;
    private String extraPrice;
    private String color;
    private String losDamage;
    private String available;
//    @OneToMany(mappedBy = "regNumber", cascade = CascadeType.ALL)
//    private List<RentDetail> rental_details = new ArrayList<>();
}
