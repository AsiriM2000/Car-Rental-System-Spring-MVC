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
    private String carQty;
}
