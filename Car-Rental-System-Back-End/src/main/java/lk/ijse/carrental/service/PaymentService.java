package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentService {

    void savePayment(PaymentDTO dto);
    void updatePayment(PaymentDTO dto);
    void deletePayment(String payId);
    ArrayList<PaymentDTO> getAllPayment();
    String generatePayId();
    double allIncome();
    double getDailyIncome(String date);
    String getMonthlyIncome();
}
