package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Car SET imageLocation=:imageLocation WHERE regNumber=:regNumber", nativeQuery = true)
    void updateCarFilePaths(@Param("imageLocation") String imageLocation, @Param("regNumber") String regNumber);

    @Override
    long count();
    Car findByCarName(String carName);

    @Query(value = "select * from Car where brand=?",nativeQuery = true)
    List<Car> searchCarBrand(String brand);

    @Query(value = "select * from Car where type=?",nativeQuery = true)
    List<Car> searchCarType(String type);
}
