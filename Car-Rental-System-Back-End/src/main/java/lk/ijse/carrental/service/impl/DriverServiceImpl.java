package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.entity.Driver;
import lk.ijse.carrental.repo.DriverRepo;
import lk.ijse.carrental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverEmail())){
            throw new RuntimeException("Driver "+dto.getDriverEmail()+" Already Exist...!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriverEmail())){
            throw new RuntimeException("Driver "+dto.getDriverEmail()+" Not Available Update...!");
        }
        repo.save(mapper.map(dto,Driver.class));
    }

    @Override
    public void deleteDriver(String email) {
        if (!repo.existsById(email)){
            throw new RuntimeException("Driver "+email+" Not Available Delete...!");
        }
        repo.deleteById(email);
    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }
}
