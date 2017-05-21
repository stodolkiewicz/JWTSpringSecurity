package com.security.mySecurity.controllers;

import com.security.mySecurity.domain.LoginCredentials;
import com.security.mySecurity.domain.Profile;
import com.security.mySecurity.exceptions.FailedToLoginException;
import com.security.mySecurity.services.JwtService;
import com.security.mySecurity.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Admin on 16/05/2017.
 */
@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtService jwtService;

    @RequestMapping(method = RequestMethod.POST)
    public Profile login(@RequestBody LoginCredentials loginCredentials,
                      HttpServletResponse httpServletResponse) throws FailedToLoginException {

        System.out.print(loginCredentials);
        Profile profile = loginService.login(loginCredentials);
        String token = jwtService.tokenFor(profile);
        httpServletResponse.setHeader("Token", token);

        return profile;
    }
}
