package lk.ijse.carrental.repo;

import lk.ijse.carrental.dto.PaymentDTO;
import lk.ijse.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,String> {
    @Query(value = "SELECT YEAR(date) AS Year,MONTH(date) AS Month,SUM(total) AS Total FROM Payment  GROUP BY YEAR(date), MONTH(date)",nativeQuery = true)
    List<PaymentDTO> getMonthlyIncome() throws SQLException,ClassNotFoundException;

}
