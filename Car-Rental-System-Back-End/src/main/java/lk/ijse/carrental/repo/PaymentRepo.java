package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
