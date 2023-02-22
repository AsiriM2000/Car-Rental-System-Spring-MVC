package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String regNumber);
    ArrayList<CarDTO> getAllCar();
    long count();
}
