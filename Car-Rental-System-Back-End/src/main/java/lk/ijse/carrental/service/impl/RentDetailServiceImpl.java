package lk.ijse.carrental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.dto.RentDetailDTO;
import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.entity.RentDetail;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.repo.RentDetailRepo;
import lk.ijse.carrental.service.RentDetailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class RentDetailServiceImpl implements RentDetailService {

    @Autowired
    RentDetailRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveRentalDetail(RentDetailDTO dto) {
        if (repo.existsById(dto.getRentId())){
            throw new RuntimeException("Rent "+dto.getRentId()+" Already Exist...!");
        }
        repo.save(mapper.map(dto, RentDetail.class));

    }

    @Override
    public void updateRentalDetail(RentDetailDTO dto) {
        if (!repo.existsById(dto.getRentId())){
            throw new RuntimeException("Rent "+dto.getRentId()+" Not Available...!");
        }
        repo.save(mapper.map(dto,RentDetail.class));
    }

    @Override
    public ArrayList<RentDetailDTO> getAllRentDetail() {
        return mapper.map(repo.getAll(),new TypeToken<ArrayList<RentDetailDTO>>(){}.getType());
    }

    @Override
    public long count() {
        return repo.count();
    }
}
