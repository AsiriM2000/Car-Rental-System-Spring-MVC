package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class IncomeDTO {
    private double total;
    private String year;
    private String month;

    public IncomeDTO(String year, String month, double total) {
        this.year = year;
        this.month = month;
        this.total = total;
    }
}
