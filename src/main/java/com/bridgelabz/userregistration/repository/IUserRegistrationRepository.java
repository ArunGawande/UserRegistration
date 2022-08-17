package com.bridgelabz.userregistration.repository;

import com.bridgelabz.userregistration.model.UserRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRegistrationRepository extends JpaRepository<UserRegistrationModel,Long>{

    Optional<UserRegistrationModel> findByEmailId(String mail);

    Optional<UserRegistrationModel> findByMail(String mail);
}
