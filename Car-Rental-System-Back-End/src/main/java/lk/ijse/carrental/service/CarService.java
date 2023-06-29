package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.entity.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String regNumber);
    ArrayList<CarDTO> getAllCar();
    long count();
    CarDTO searchByCarName(String carName0);
    ArrayList<CarDTO> searchCarBrand(String brand);
    ArrayList<CarDTO> searchCarType(String type);
    void uploadCarImages(String imageLocation, String regNumber);
}
