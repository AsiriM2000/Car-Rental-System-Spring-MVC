package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.RentDetailDTO;
import lk.ijse.carrental.service.RentDetailService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping
    public ResponseUtil getAllRentDetail(){
        ArrayList<RentDetailDTO> allRentalDetail = service.getAllRentalDetail();
        return new ResponseUtil("200","Success",allRentalDetail);
    }

    @PutMapping
    public ResponseUtil updateRentD(@RequestBody RentDetailDTO dto){
        service.updateRentalDetail(dto);
        return new ResponseUtil("200",dto.toString()+" Accept Successful...!",null);
    }

    @GetMapping( "/allCount")
    public ResponseUtil count(){
        long count = service.count();
        return new ResponseUtil("200","Success",count);
    }

    @GetMapping(params = "rentId")
    public ResponseUtil searchDetail(String rentId){
        RentDetailDTO rentData = service.searchDetailRentId(rentId);
        return new ResponseUtil("200","Success",rentData);
    }
}
