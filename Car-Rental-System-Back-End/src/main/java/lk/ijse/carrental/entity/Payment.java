package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {

    @Id
    private String payId;
    private String rentId;
    private String paymentMethod;
    private String status;
    private double payment;
    private double damage;
    private double extra;
    private String date;
    private double total;

}
