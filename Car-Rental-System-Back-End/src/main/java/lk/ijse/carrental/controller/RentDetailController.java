package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.RentDetailDTO;
import lk.ijse.carrental.entity.RentDetail;
import lk.ijse.carrental.repo.RentDetailRepo;
import lk.ijse.carrental.service.RentDetailService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentDetailController {

    private static final ArrayList<String> bankSlips = new ArrayList<>();


    @Autowired
    RentDetailService service;

    @Autowired
    RentDetailRepo repo;

    @PostMapping
    public ResponseUtil saveRentDetail(@RequestBody RentDetailDTO dto){
        service.saveRentalDetail(dto);
        return new ResponseUtil("200",dto.toString()+" Save Successful...!",null);
    }

    @GetMapping("/rentDetail")
    public ResponseUtil getAllRentDetail(){
        List<RentDetail> all = repo.getAll();
        return new ResponseUtil("200","Success",all);
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

    @PostMapping(path = "/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity uploadFileWithSpringWay(@RequestPart("bankSlip") MultipartFile bankSlip) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();
            bankSlip.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + bankSlip.getOriginalFilename()));

            bankSlips.add("uploads/" + bankSlip.getOriginalFilename());
            return  ResponseEntity.ok(HttpStatus.OK);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllImagesFromDatabase() {
        return new ResponseEntity(bankSlips, HttpStatus.OK);
    }

}
