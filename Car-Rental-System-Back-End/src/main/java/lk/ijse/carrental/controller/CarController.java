package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.service.CarService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService service;

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto){
        service.saveCar(dto);
        return new ResponseUtil("200",dto.toString()+" Save Successful...!",null);
    }

    @GetMapping
    public ResponseUtil getAllCar(){
        ArrayList<CarDTO> allCar = service.getAllCar();
        return new ResponseUtil("200","Success...!",allCar);
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto){
        service.updateCar(dto);
        return new ResponseUtil("200",dto.toString()+" Update Successful...!",null);
    }

    @DeleteMapping
    public ResponseUtil deleteCar(String regNumber){
        service.deleteCar(regNumber);
        return new ResponseUtil("200", regNumber+" Delete Successful...!",null);
    }
}
