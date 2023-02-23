package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.PaymentDTO;
import lk.ijse.carrental.entity.Payment;
import lk.ijse.carrental.repo.PaymentRepo;
import lk.ijse.carrental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void savePayment(PaymentDTO dto) {
        if (repo.existsById(dto.getPayId())){
            throw new RuntimeException("Payment "+dto.getPayId()+" Already Exist...!");
        }
        repo.save(mapper.map(dto, Payment.class));
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (!repo.existsById(dto.getPayId())){
            throw new RuntimeException("Payment "+dto.getPayId()+" Not Available Update...!");
        }
        repo.save(mapper.map(dto, Payment.class));
    }

    @Override
    public void deletePayment(String payId) {
        if (!repo.existsById(payId)){
            throw new RuntimeException("Payment "+payId+" Not Available Delete...!");
        }
        repo.deleteById(payId);
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayment() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<PaymentDTO>>(){}.getType());
    }
}
