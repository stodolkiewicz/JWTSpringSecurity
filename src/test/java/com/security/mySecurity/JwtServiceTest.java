package com.security.mySecurity;

import com.security.mySecurity.domain.Profile;
import com.security.mySecurity.services.JwtService;
import com.security.mySecurity.services.ProfileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtServiceTest {

    @Autowired
    ProfileService profileService;

    @Autowired
    JwtService jwtService;

    @MockBean
    private Profile profile;

    @Before
    public void setup(){
        profile = profileService.getProfile("username");
    }

    @Test
    public void shouldCreateJWTtoken(){
        String token = jwtService.tokenFor(profile);
        System.out.print("myToken is: " + token);
        jwtService.verify(token);
        assertNotNull(token);
    }

}
