package com.security.mySecurity.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.text.MessageFormat.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Created by Admin on 16/05/2017.
 */
public class ProfileNotFoundException extends RuntimeException {

  public ProfileNotFoundException(String username){
        super(new StringBuilder("Profile with username " + username + " does not exist.").toString());
    }
}
