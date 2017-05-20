package com.security.mySecurity.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.mySecurity.domain.Login;
import com.security.mySecurity.domain.Profile;
import com.security.mySecurity.exceptions.ProfileNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 15/05/2017.
 */
@Service
public class ProfileService {
    private List<Profile> profiles = new ArrayList<>();

    ProfileService(){
        Login login = new Login(
            "username",
            "password",
            "salt",
            "md5",
            "sha1",
            "sha256");

        Profile profile = new Profile(
            "firstName",
            "lastName",
            "email",
            login);

        profiles.add(profile);
    }

    public Profile getProfile(String username, String password) {
        return profiles.stream()
            .filter( profile -> profile.getLogin().getUsername().equals(username) )
            .filter( profile -> profile.getLogin().getPassword().equals(password))
            .findFirst()
            .orElseThrow(() -> new ProfileNotFoundException(username));
    }
}
