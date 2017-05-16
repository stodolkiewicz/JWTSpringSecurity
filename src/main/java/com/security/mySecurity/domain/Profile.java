package com.security.mySecurity.domain;

import lombok.Data;

/**
 * Created by Admin on 15/05/2017.
 */
@Data
public class Profile {
    private String firstName;
    private String lastName;
    private String email;
    private Login login;

    public Profile(String firstName, String lastName, String email, Login login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
    }
}
