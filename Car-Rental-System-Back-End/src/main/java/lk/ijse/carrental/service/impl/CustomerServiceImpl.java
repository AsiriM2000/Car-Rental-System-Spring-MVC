package lk.ijse.carrental.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.dto.CustomerVerificationImgDTO;
import lk.ijse.carrental.entity.Customer;
import lk.ijse.carrental.entity.CustomerVarificationImg;
import lk.ijse.carrental.repo.CustomerRepo;
import lk.ijse.carrental.repo.CustomerVerificationImgRepo;
import lk.ijse.carrental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(repo.existsById(dto.getEmail())){
            throw new RuntimeException("Customer "+dto.getEmail()+" Already Exist...!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getEmail())) {
            throw new RuntimeException("Customer "+dto.getEmail()+" Not Available To Update...!");
        }
        repo.save(mapper.map(dto,Customer.class));
    }

    @Override
    public void deleteCustomer(String email) {
        if (!repo.existsById(email)){
            throw new RuntimeException("Customer "+email+" Not Available to Delete...!");
        }
        repo.deleteById(email);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO searchByCustomerEmail(String email) {
        return mapper.map(repo.findByEmail(email),CustomerDTO.class);
    }

    @Override
    public CustomerDTO searchByCustomerEmailAndPassword(String email, String password) {
        return mapper.map(repo.findByEmailAndPassword(email,password),CustomerDTO.class);
    }

    @Override
    public long count() {
        return repo.count();
    }

}
