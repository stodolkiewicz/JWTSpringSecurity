package com.security.mySecurity.controllers;

import com.security.mySecurity.domain.Profile;
import com.security.mySecurity.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Admin on 15/05/2017.
 */
@RestController("myProfileControllerBecauseOfConflictingBeanNames")
@RequestMapping(path = "/profile")
class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public Profile getProfile(@PathVariable String username){
        return profileService.getProfile(username);
    }

}
