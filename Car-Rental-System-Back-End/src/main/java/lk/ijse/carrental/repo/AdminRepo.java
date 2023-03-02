package lk.ijse.carrental.repo;

import lk.ijse.carrental.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
    Admin findByUsernameAndPassword(String username,String password);
}
