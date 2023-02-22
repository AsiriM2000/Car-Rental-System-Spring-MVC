package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (repo.existsById(dto.getRegNumber())){
            throw new RuntimeException("Car "+dto.getRegNumber()+" Already Exist...!");
        }
        repo.save(mapper.map(dto, Car.class));
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (!repo.existsById(dto.getRegNumber())){
            throw new RuntimeException("Car "+dto.getRegNumber()+" Not Available To Update...!");
        }
        repo.save(mapper.map(dto,Car.class));
    }

    @Override
    public void deleteCar(String regNumber) {
        if (!repo.existsById(regNumber)){
            throw new RuntimeException("Car "+regNumber+" Not Available To delete...!");
        }
        repo.deleteById(regNumber);
    }

    @Override
    public ArrayList<CarDTO> getAllCar() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public long count() {
        return repo.count();
    }
}
