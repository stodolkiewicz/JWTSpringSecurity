package com.security.mySecurity.services;

import com.security.mySecurity.domain.LoginCredentials;
import com.security.mySecurity.domain.Profile;
import com.security.mySecurity.exceptions.FailedToLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    ProfileService profileService;

    public Profile login(LoginCredentials loginCredentials) throws FailedToLoginException {
        Profile profile = profileService.getProfile(loginCredentials.getUsername());
        if(profile.getLogin().getPassword().equals(loginCredentials.getPassword())){
            return profile;
        }else throw new FailedToLoginException();
    };
}
