package com.security.mySecurity.services;
import java.time.LocalDateTime;
import java.util.Date;
import com.security.mySecurity.domain.Profile;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import static java.time.ZoneOffset.UTC;

@Service
public class JwtService {
    //should be encrypted - ex. in database
    private String secretKey = "dzem44";

    public String tokenFor(Profile profile){
        Date expirationDate = Date.from(LocalDateTime.now().plusMinutes(15).toInstant(UTC));
        return Jwts.builder()
            .setSubject(profile.getLogin().getUsername())
            .setExpiration(expirationDate)
            .setIssuer("issuer1")
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
    }
}
