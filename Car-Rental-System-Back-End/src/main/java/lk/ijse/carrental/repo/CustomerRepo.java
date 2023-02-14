package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findByCustEmail(String email);
    Customer findByCustEmailAndPassword(String email,String password);
}
