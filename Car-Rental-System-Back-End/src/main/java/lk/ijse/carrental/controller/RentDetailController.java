package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.RentDetailDTO;
import lk.ijse.carrental.service.RentDetailService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentDetailController {

    @Autowired
    RentDetailService service;

    @PostMapping
    public ResponseUtil saveRentDetail(@RequestBody RentDetailDTO dto){
        service.saveRentalDetail(dto);
        return new ResponseUtil("200",dto.toString()+" Save Successful...!",null);
    }
}
