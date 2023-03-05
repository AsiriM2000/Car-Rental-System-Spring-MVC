package lk.ijse.carrental.repo;

import lk.ijse.carrental.config.WebRootConfig;
import lk.ijse.carrental.dto.PaymentDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = WebRootConfig.class)
@ExtendWith(SpringExtension.class)
@Transactional
class PaymentRepoTest {

    @Autowired
    PaymentRepo repo;

    @Test
    public void test(){
        double v = repo.allIncome();
        System.out.println(v);
    }
}