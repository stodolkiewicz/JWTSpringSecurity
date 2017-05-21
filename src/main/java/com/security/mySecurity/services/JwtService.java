package com.security.mySecurity.services;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import com.security.mySecurity.domain.Profile;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.ZoneOffset.UTC;

@Service
public class JwtService {
    //should be encrypted - ex. in database
    private byte[] secretKey = "dzem44".getBytes();

    @Autowired
    private ProfileService profileService;

    public String tokenFor(Profile profile){
        Date expirationDate = Date.from(LocalDateTime.now().plusMinutes(15).toInstant(UTC));
        return Jwts.builder()
            .setSubject(profile.getLogin().getUsername())
            .setExpiration(expirationDate)
            .setIssuer("issuer1")
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
    }

    public Profile verify(String token){
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return profileService.getProfile(claims.getBody().getSubject());
    }
}
