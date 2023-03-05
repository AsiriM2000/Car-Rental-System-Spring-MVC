package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.PaymentDTO;
import lk.ijse.carrental.service.PaymentService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping
    public ResponseUtil savePayment(@RequestBody PaymentDTO dto){
        service.savePayment(dto);
        return new ResponseUtil("200",dto.toString()+" Save Successful...!",null);
    }

    @PutMapping
    public ResponseUtil updatePayment(@RequestBody PaymentDTO dto){
        service.updatePayment(dto);
        return new ResponseUtil("200",dto.toString()+" Update Successful...!",null);
    }

    @DeleteMapping
    public ResponseUtil deletePayment(String payId){
        service.deletePayment(payId);
        return new ResponseUtil("200",payId+" Delete Successful...!",null);
    }

    @GetMapping
    public ResponseUtil getAllPayment(){
        ArrayList<PaymentDTO> allPayment = service.getAllPayment();
        return new ResponseUtil("200","Success",allPayment);
    }


    @GetMapping("/generatePayId")
    public ResponseUtil generateRentId(){
        String payId = service.generatePayId();
        return new ResponseUtil("200","Success",payId);
    }

    @GetMapping("/allIncome")
    public ResponseUtil allIncome(){
        double allIncome = service.allIncome();
        return new ResponseUtil("200","Success",allIncome);
    }

    @GetMapping(params = "date")
    public ResponseUtil getDailyIncome(String date){
        double dailyIncome = service.getDailyIncome(date);
        return new ResponseUtil("200","Success",dailyIncome);
    }

    @GetMapping("/monthlyIncome")
    public ResponseUtil getMonthlyIncome(){
        String monthlyIncome = service.getMonthlyIncome();
        return new ResponseUtil("200","Success",monthlyIncome);
    }

}
