package lk.ijse.carrental.repo;

import lk.ijse.carrental.config.WebRootConfig;
import lk.ijse.carrental.dto.PaymentDTO;
import lk.ijse.carrental.entity.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = WebRootConfig.class)
@ExtendWith(SpringExtension.class)
@Transactional
class PaymentRepoTest {

    @Autowired
    PaymentRepo repo;

    @Test
    public void test() throws SQLException, ClassNotFoundException {
        List<Payment> monthlyIncome = repo.getMonthlyIncome();
       for (Payment payment: monthlyIncome){
           System.out.println(payment);
       }

    }
}