package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET imageLocation=:imageLocation WHERE nic=:nic", nativeQuery = true)
    void updateCustomerFilePaths(@Param("imageLocation") String imageLocation, @Param("nic") String nic);

    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email,String password);
    @Override
    long count();
}
