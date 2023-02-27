package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.dto.CustomerVerificationImgDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String email);
    ArrayList<CustomerDTO> getAllCustomer();
    void saveCustomerWithImg(String customer, MultipartFile file);
    CustomerDTO searchByCustomerEmail(String email);
    CustomerDTO searchByCustomerEmailAndPassword(String nicNum,String password);
    long count();
    ArrayList<CustomerVerificationImgDTO> getAllImg();
}
