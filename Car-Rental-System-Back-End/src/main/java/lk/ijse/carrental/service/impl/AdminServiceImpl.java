package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.AdminDTO;
import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.entity.Admin;
import lk.ijse.carrental.repo.AdminRepo;
import lk.ijse.carrental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void signUpAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminId())){
            throw new RuntimeException("Admin "+dto.getAdminId()+" Already Exist...!");
        }
        repo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public AdminDTO searchByAdminUsernameAndPassword(String username, String password) {
        return mapper.map(repo.findByUsernameAndPassword(username,password),AdminDTO.class);
    }

}
