package com.bridgelabz.userregistration.controller;

import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationModel;
import com.bridgelabz.userregistration.service.IUserRegistrationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    IUserRegistrationService iuserRegistrationService;

    //
    @GetMapping("/Welcome")
   public List<UserRegistrationModel> readAll(){
        return iuserRegistrationService.readAll();
    }


    @PostMapping("/Create")
    public UserRegistrationModel create(@RequestBody UserRegistrationDTO userRegistrationDTO){
        return iuserRegistrationService.create(userRegistrationDTO);
    }
    @PutMapping("/UserUpdate/{id}")
    public UserRegistrationModel UserUpdate(@RequestBody UserRegistrationDTO userRegistrationDTO,@PathVariable long id){
        return iuserRegistrationService.UserUpdate(userRegistrationDTO,id);
    }

     @DeleteMapping("/delete/{id}")
    public UserRegistrationModel delete(@PathVariable long id) {
         return iuserRegistrationService.delete(id);
     }
         @GetMapping("/readbytoken")
         public UserRegistrationModel readByToken(@RequestHeader String token) {
             return iuserRegistrationService.readByToken(token);
         }
    @PutMapping("/updatebytoken")
    public UserRegistrationModel updateByToken(@RequestHeader String token,@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return iuserRegistrationService.updateBytoken(token, userRegistrationDTO);
    }

    @PostMapping("/login")
    public Response login(@RequestHeader String mail, @RequestHeader String password) {
        return iuserRegistrationService.login(mail,password);
    }

    @PostMapping("/sendmail")
    public void sendMail(@RequestHeader String mail,@RequestHeader String subject,@RequestHeader String body) {
        iuserRegistrationService.sendMail(mail,subject,body);
    }

}

