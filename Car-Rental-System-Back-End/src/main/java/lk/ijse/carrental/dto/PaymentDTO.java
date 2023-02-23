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
    private String pStatus;
    private double payment;
    private double dCost;
    private double eCost;
    private String date;
}
