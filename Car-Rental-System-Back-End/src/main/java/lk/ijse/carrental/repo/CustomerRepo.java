package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email,String password);
    @Override
    long count();

}
