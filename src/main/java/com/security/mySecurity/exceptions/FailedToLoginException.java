package com.security.mySecurity.exceptions;

import com.security.mySecurity.domain.Login;

/**
 * Created by Admin on 20/05/2017.
 */
public class FailedToLoginException extends Throwable {

    public FailedToLoginException(){
        super("Failed to log in. Incorrect username and/or password.");
    }
}
