package lk.ijse.carrental.repo;

import lk.ijse.carrental.dto.PaymentDTO;
import lk.ijse.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.StringJoiner;

public interface PaymentRepo extends JpaRepository<Payment, String> {

    @Query(value = "SELECT SUM(total) FROM Payment", nativeQuery = true)
    double allIncome();

    @Query(value = "SELECT SUM(total) FROM Payment WHERE date = ?", nativeQuery = true)
    double dailyIncome(String date);

    @Query(value = "SELECT YEAR(date),MONTH(date),SUM(total)  Total FROM payment  GROUP BY YEAR(date), MONTH(date)", nativeQuery = true)
    String getMonthlyIncome();

    @Query(value = "SELECT payId FROM Payment ORDER BY payId DESC LIMIT 1", nativeQuery = true)
    String generatePayId();
}
