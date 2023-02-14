package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    ArrayList<CustomerDTO> getAllCustomer();
    CustomerDTO searchByCustomerEmail(String email);
    CustomerDTO searchByCustomerEmailAndPassword(String email,String password);
}
