package com.bridgelabz.userregistration.service;

import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationModel;
import org.apache.coyote.Response;

import java.util.List;

public interface IUserRegistrationService {

    UserRegistrationModel create(UserRegistrationDTO userRegistrationDTO);
    List<UserRegistrationModel> readAll();

    //UserRegistrationModel update(long id);
    UserRegistrationModel UserUpdate(UserRegistrationDTO userRegistrationDTO, long id);

    UserRegistrationModel update(UserRegistrationDTO userRegistrationDTO, long id);

    UserRegistrationModel delete(long id);
    Response login(String mail, String password);
    UserRegistrationModel readByToken(String token);

    UserRegistrationModel deletebytoken(String token);

    UserRegistrationModel updateBytoken(String token, UserRegistrationDTO userRegistrationDTO);
    void sendMail(String mail, String subject, String body);

}
