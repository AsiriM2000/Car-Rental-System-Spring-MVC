package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.entity.Customer;
import lk.ijse.carrental.repo.CustomerRepo;
import lk.ijse.carrental.service.CustomerService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
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

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        service.saveCustomer(dto);
        return new ResponseUtil("200",dto.toString()+ " Register Successful...!",null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseUtil("200",dto.toString()+"update Successful...!",null);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(String email){
        service.deleteCustomer(email);
        return new ResponseUtil("200", email +" Delete Successful...!",null);
    }

    @PostMapping(value = "/upload/{nicNum}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadFile(@RequestParam("myFile") MultipartFile myFile, @PathVariable("nicNum") String nicNum){
        System.out.println("Hey");
        System.out.println(nicNum);
        System.out.println(myFile.getName());

        service.saveCustomerWithImg(nicNum,myFile);
        return new ResponseUtil("200", " Register Successful...!", null);
    }


    @PutMapping(path = "/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity uploadFile(@RequestPart("myFile") MultipartFile myFile, @RequestPart("myFile") byte[] isFile, @RequestPart("myFile") Part myPart) {
        System.out.println(isFile);
        System.out.println(myPart.getSubmittedFileName());

        System.out.println("================================");

        System.out.println(myFile.getOriginalFilename());
        System.out.println(myPart.getSubmittedFileName());

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();

            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));

            return new ResponseEntity("Successfully Uploaded", HttpStatus.OK);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping(path = "/image",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllImagesFromDatabase() {
        return null;
    }

    @GetMapping
    public ResponseUtil getAllCustomer(){
        ArrayList<CustomerDTO> allCustomer = service.getAllCustomer();
        return new ResponseUtil("200"," Success",allCustomer);
    }

    @GetMapping(params = "email")
    public ResponseUtil searchCustomerByEmail(String email){
        CustomerDTO customer = service.searchByCustomerEmail(email);
        return new ResponseUtil("200"," Success",customer);
    }

    @GetMapping(params = {"email","password"})
    public ResponseUtil searchCustomerByEmailAndPassword(String email,String password){
        CustomerDTO customer = service.searchByCustomerEmailAndPassword(email,password);
        return new ResponseUtil("200"," Success",customer);
    }

    @GetMapping("/count")
    public ResponseUtil count(){
        long count = service.count();
        return new ResponseUtil("200"," Success",count);
    }

}
