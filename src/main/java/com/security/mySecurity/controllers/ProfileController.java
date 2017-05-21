package com.security.mySecurity.controllers;

import com.security.mySecurity.domain.Profile;
import com.security.mySecurity.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

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
