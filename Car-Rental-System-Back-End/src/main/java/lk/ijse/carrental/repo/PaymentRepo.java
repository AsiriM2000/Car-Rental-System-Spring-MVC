package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepo extends JpaRepository<Payment,String> {
    @Query(value = "SELECT SUM(total) FROM Payment",nativeQuery = true)
    Payment selectTotals();
}
