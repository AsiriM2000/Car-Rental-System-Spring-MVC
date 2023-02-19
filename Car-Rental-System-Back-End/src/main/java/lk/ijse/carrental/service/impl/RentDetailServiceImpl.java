package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.RentDetailDTO;
import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.entity.RentDetail;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.repo.RentDetailRepo;
import lk.ijse.carrental.service.RentDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

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
            throw new RuntimeException("Rent"+dto.getRentId()+" Already Exist...!");
        }
        repo.save(mapper.map(dto, RentDetail.class));

    }

    @Override
    public ArrayList<RentDetailDTO> getAllRentalDetail() {
        return null;
    }
}
