package lk.ijse.carrental.repo;

import lk.ijse.carrental.config.WebRootConfig;
import lk.ijse.carrental.entity.RentDetail;
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
class RentDetailRepoTest {
    @Autowired
    RentDetailRepo repo;

    @Test
    public void test(){
        RentDetail r001 = repo.findByRentId("R002");
        System.out.println(r001);
    }

}