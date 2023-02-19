package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {
    private String carName;
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
    private int carQty;
}
