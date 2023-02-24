package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PaymentDTO {

    private String payId;
    private String email;
    private String status;
    private double payment;
    private double damage;
    private double extra;
    private String date;
    private double total;
}