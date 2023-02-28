package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "select * from Driver where driverEmail=?",nativeQuery = true)
    List<Driver> searchDriverEmail(String driverEmail);
}
