package com.security.mySecurity.security.jwtUtilities;

import com.security.mySecurity.domain.Profile;

/**
 * Created by Admin on 16/05/2017.
 */
public class JwtService {
    private static final String issuer = "issuerDawid";

    //should be encrypted - ex. in database
    private String secretKey = "dzem44";

    public String tokenFor(Profile profile){
        Date expirationDate = Date.from()
    }
}
