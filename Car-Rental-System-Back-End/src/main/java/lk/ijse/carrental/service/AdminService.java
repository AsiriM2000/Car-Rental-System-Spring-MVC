package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.AdminDTO;

public interface AdminService {
    void signUpAdmin(AdminDTO dto);
    AdminDTO searchByAdminUsernameAndPassword(String username, String password);
}
