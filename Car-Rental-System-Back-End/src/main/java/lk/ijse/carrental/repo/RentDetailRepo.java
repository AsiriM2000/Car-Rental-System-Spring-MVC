package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentDetailRepo extends JpaRepository<RentDetail,String> {
    RentDetail findByRentId(String rentId);
    @Override
    long count();
}
