package com.bridgelabz.userregistration.service;


import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationModel;
import com.bridgelabz.userregistration.repository.IUserRegistrationRepository;
import com.bridgelabz.userregistration.util.TokenUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService implements IUserRegistrationService {
    @Autowired
    IUserRegistrationRepository iUserRegistrationRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public UserRegistrationModel create(UserRegistrationDTO userRegistrationDTO) {
        UserRegistrationModel userRegistrationModel = new UserRegistrationModel(userRegistrationDTO);
        iUserRegistrationRepository.save(userRegistrationModel);
        return userRegistrationModel;
    }

    @Override
    public List<UserRegistrationModel> readAll() {
        List<UserRegistrationModel> list =iUserRegistrationRepository.findAll();
        return list;
    }

    @Override
    public UserRegistrationModel UserUpdate(UserRegistrationDTO userRegistrationDTO, long id) {
        return null;
    }

    @Override
    public UserRegistrationModel update(UserRegistrationDTO userRegistrationDTO, long id) {
        Optional<UserRegistrationModel> isUserPresent = userRegistrationDTO.findById(id);

        isUserPresent.get().setFirstName(userRegistrationDTO.getFirstName());
        isUserPresent.get().setLastName(userRegistrationDTO.getLastName());
        isUserPresent.get().setMail(userRegistrationDTO.getMail());
        isUserPresent.get().setPassword(userRegistrationDTO.getPassword());
        iUserRegistrationRepository.save(isUserPresent.get());

        return isUserPresent.get();
    }

    @Override
    public UserRegistrationModel delete(long id) {
        Optional<UserRegistrationModel> isUserPresent = iUserRegistrationRepository.findById(id);
        iUserRegistrationRepository.delete(isUserPresent.get());
        return isUserPresent.get();
    }

    @Override
    public Response login(String mail, String password) {
        Optional<UserRegistrationModel> user = iUserRegistrationRepository.findByMail(mail);
        if(user.get().getPassword().equals(password)) {
            String token = tokenUtil.createToken(user.get().getUser_Id());
            return new Response(100,"Login Successful",token);
        }else
            return new Response("Could not login");
    }

    @Override
    public UserRegistrationModel deletebytoken(String token) {
        long userId = tokenUtil.decodeToken(token);
        Optional<UserRegistrationModel> user = iUserRegistrationRepository.findById(userId);
        iUserRegistrationRepository.delete(user.get());
        return user.get();
    }

    @Override
    public UserRegistrationModel updateBytoken(String token ,UserRegistrationDTO userRegistrationDTO) {
        long userId = tokenUtil.decodeToken(token);
        Optional<UserRegistrationModel> user = iUserRegistrationRepository.findById(userId);
        user.get().setFirstName(userRegistrationDTO.getFirstName());
        user.get().setLastName(userRegistrationDTO.getLastName());
        user.get().setMail(userRegistrationDTO.getMail());
        user.get().setPassword(userRegistrationDTO.getPassword());
        iUserRegistrationRepository.save(user.get());
        return user.get();
    }

    @Override
    public UserRegistrationModel readByToken(String token) {
        long userId = tokenUtil.decodeToken(token);
        Optional<UserRegistrationModel> data = iUserRegistrationRepository.findById(userId);
        if(data.isPresent())
            return data.get();
        return null;
    }

    @Override
    public void sendMail(String mail, String subject, String body) {
        Optional<UserRegistrationModel> user =iUserRegistrationRepository.findByMail(mail);
        if(user.isPresent()) {
            mailService.send(mail, subject, body);
        }

    }

}

