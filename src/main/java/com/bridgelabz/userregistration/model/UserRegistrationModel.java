package com.bridgelabz.userregistration.model;

import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class UserRegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long user_Id;
    private String firstName;
    private String lastName;
    @CreationTimestamp
    private LocalDate cratedDate;
    @UpdateTimestamp
    private LocalDate updatedDate;
    private String mail;
    private String password;


    public UserRegistrationModel(){

    }
    public UserRegistrationModel(UserRegistrationDTO UserRegistrationDTO){


        this.firstName = UserRegistrationDTO.firstName;
        this.lastName  = UserRegistrationDTO.lastName;
        this.mail   = UserRegistrationDTO.mail;
        this.password  = UserRegistrationDTO.password;

    }

    public void setMail(Object mail) {

    }
}
