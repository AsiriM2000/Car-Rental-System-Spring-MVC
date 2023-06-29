package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.service.CarService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService service;

    @PostMapping
    public ResponseUtil saveCar(@RequestBody CarDTO dto){
        service.saveCar(dto);
        return new ResponseUtil("200",dto.toString()+" Save Successful...!",null);
    }

    @PutMapping(path = "/uploadImg/{regNumber}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("imageLocation") MultipartFile imageLocation, @PathVariable String regNumber) {
        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();

            imageLocation.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + imageLocation.getOriginalFilename()));

            String carImageLocationPath = imageLocation.getOriginalFilename();

            service.uploadCarImages(carImageLocationPath, regNumber);

            return new ResponseUtil("200", "Uploaded", null);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("500",e.getMessage(),null);
        }
    }

    @GetMapping
    public ResponseUtil getAllCar(){
        ArrayList<CarDTO> allCar = service.getAllCar();
        return new ResponseUtil("200","Success...!",allCar);
    }

    @GetMapping("/count")
    public ResponseUtil getCount(){
        long count = service.count();
        return new ResponseUtil("200","Success",count);
    }

    @GetMapping(params = "carName")
    public ResponseUtil getAllCarName(String carName){
        CarDTO carNameD = service.searchByCarName(carName);
        return new ResponseUtil("200","Success",carNameD);
    }

    @GetMapping(params = "brand")
    public ResponseUtil getAllCarBrand(String brand){
        ArrayList<CarDTO> carBrand = service.searchCarBrand(brand);
        return new ResponseUtil("200","Success",carBrand);
    }

    @GetMapping(params = "type")
    public ResponseUtil getAllCarType(String type){
        ArrayList<CarDTO> carType = service.searchCarType(type);
        return new ResponseUtil("200","Success",carType);
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
