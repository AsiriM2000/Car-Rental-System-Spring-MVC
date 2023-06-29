package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.service.CustomerService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto) {
        service.saveCustomer(dto);
        return new ResponseUtil("200", dto.toString() + " Register Successful...!", null);
    }

    @PutMapping(path = "/uploadImg/{nicNum}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("imageLocation") MultipartFile imageLocation, @PathVariable String nicNum) {
        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();

            imageLocation.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + imageLocation.getOriginalFilename()));

            String customerImageLocationPath = imageLocation.getOriginalFilename();

            service.uploadCustomerImages(customerImageLocationPath, nicNum);

            return new ResponseUtil("200", "Uploaded", null);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("500",e.getMessage(),null);
        }
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        return new ResponseUtil("200", dto.toString() + "update Successful...!", null);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String email) {
        service.deleteCustomer(email);
        return new ResponseUtil("200", email + " Delete Successful...!", null);
    }

    @GetMapping
    public ResponseUtil getAllCustomer() {
        ArrayList<CustomerDTO> allCustomer = service.getAllCustomer();
        return new ResponseUtil("200", " Success", allCustomer);
    }

    @GetMapping(params = "email")
    public ResponseUtil searchCustomerByEmail(String email) {
        CustomerDTO customer = service.searchByCustomerEmail(email);
        return new ResponseUtil("200", " Success", customer);
    }

    @GetMapping(params = {"email", "password"})
    public ResponseUtil searchCustomerByEmailAndPassword(String email, String password) {
        CustomerDTO customer = service.searchByCustomerEmailAndPassword(email, password);
        return new ResponseUtil("200", " Success", customer);
    }

    @GetMapping("/count")
    public ResponseUtil count() {
        long count = service.count();
        return new ResponseUtil("200", " Success", count);
    }

}
