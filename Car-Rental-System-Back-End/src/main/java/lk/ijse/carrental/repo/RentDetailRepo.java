package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentDetailRepo extends JpaRepository<RentDetail,String> {
    @Override
    long count();
    @Query(value = "select * from RentDetail",nativeQuery = true)
    List<RentDetail> getAll();
}
