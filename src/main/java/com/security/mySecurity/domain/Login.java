package com.security.mySecurity.domain;

import lombok.Data;

/**
 * Created by Admin on 15/05/2017.
 */
@Data
public class Login {
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    public Login(String username, String password, String salt, String md5, String sha1, String sha256) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
    }
}
