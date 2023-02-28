package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {

    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    void deleteDriver(String email);
    ArrayList<DriverDTO> getAllDriver();
    ArrayList<DriverDTO> searchDriverEmail(String driverEmail);
}
