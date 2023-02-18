package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.service.DriverService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService service;

    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        service.saveDriver(dto);
        return new ResponseUtil("200",dto.toString()+ " Save Successful...!",null);
    }

    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
        return new ResponseUtil("200",dto.toString()+ " Update Successful...!",null);
    }

    @DeleteMapping
    public ResponseUtil deleteDriver(String email){
        service.deleteDriver(email);
        return new ResponseUtil("200",email+ " Delete Successful...!",null);
    }

    @GetMapping
    public ResponseUtil getAllDriver(){
        ArrayList<DriverDTO> allDriver = service.getAllDriver();
        return new ResponseUtil("200","Success",allDriver);
    }
}
