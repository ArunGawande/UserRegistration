package com.bridgelabz.userregistration.dto;

import com.bridgelabz.userregistration.model.UserRegistrationModel;
import lombok.Data;

import java.time.LocalDate;
import java.util.Optional;

@Data
public class UserRegistrationDTO {
    public String firstName;
    public String lastName;
    public String password;
    public String mail;


    public Optional<UserRegistrationModel> findById(long id) {
        return null;
    }
}




