package lk.ijse.carrental.controller;

import lk.ijse.carrental.dto.AdminDTO;
import lk.ijse.carrental.service.AdminService;
import lk.ijse.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping
    public ResponseUtil saveAdmin(@RequestBody AdminDTO dto){
        service.signUpAdmin(dto);
        return new ResponseUtil("200",dto.toString()+" SignUp Successful...!",null);
    }


    @GetMapping(params = {"username","password"})
    public ResponseUtil login(String username,String password){
        AdminDTO adminDTO = service.searchByAdminUsernameAndPassword(username, password);
        return new ResponseUtil("200","Success",adminDTO);
    }
}
