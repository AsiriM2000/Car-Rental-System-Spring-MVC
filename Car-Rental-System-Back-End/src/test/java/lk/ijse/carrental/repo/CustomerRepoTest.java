package lk.ijse.carrental.repo;

import lk.ijse.carrental.config.WebRootConfig;
import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.entity.Customer;
import lk.ijse.carrental.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration
@ContextConfiguration(classes = WebRootConfig.class)
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

    @Autowired
    CustomerService service;

    @Test
    public void test(){
    }
}