package com.security.mySecurity.services;

import com.security.mySecurity.domain.LoginCredentials;
import com.security.mySecurity.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by Admin on 16/05/2017.
 */
@Service
public class LoginService {
    //to be done -> then LoginController

    @Autowired
    ProfileService profileService;

    public Profile login(LoginCredentials loginCredentials){
      return profileService.getProfile(
          loginCredentials.getUsername(), loginCredentials.getPassword());
    };



}
