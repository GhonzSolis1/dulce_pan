package com.pasteleria;

import com.pasteleria.controller.jwt.JwtService;
import com.pasteleria.restController.exception.JwtException;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
class JwtServiceIT {

    @Autowired
    private JwtService jwtService;

    private String jwtToken;

    @BeforeEach
    void create_token() {
        this.jwtToken = this.jwtService.createToken("gsolis", Arrays.asList("ADMIN"));
    }

    @Test
    void test_create_token() {
        assertNotNull(this.jwtToken);
        assertEquals(3, this.jwtToken.split("\\.").length);
        LogManager.getLogger(this.getClass()).info("jwt<<<======" + this.jwtToken + "---");
    }

    @Test
    void test_is_bearer() {
        assertTrue(this.jwtService.isBearer(JwtService.BEARER + this.jwtToken));
    }

    @Test
    void test_user() throws JwtException  {
        assertEquals("gsolis", this.jwtService.user(JwtService.BEARER + this.jwtToken));
    }

    @Test
    void test_user_exception_non_bearer() {
        assertThrows(JwtException.class, () -> this.jwtService.user("kk " + this.jwtToken));
    }

    @Test
    void test_user_exception_non_jwt() {
        assertThrows(JwtException.class, () -> this.jwtService.user(JwtService.BEARER + this.jwtToken + "s"));
    }

    @Test
    void test_user_exception_expired_jwt() {
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYmYiOjE1OTQyNjg1OTcsInJvbGVzIjpbIkFETUlOIl0sImlzcyI6Im1pdy1zcHJpbmc1IiwiZXhwIjoxNTk0MjcyMTk3LCJpYXQiOjE1OTQyNjg1OTcsInVzZXIiOiJnc29saXMifQ.19ag0MEWIpYTElXEs71QnKgxATpoHoD9jQUPBptvol0";

        assertThrows(JwtException.class, () -> this.jwtService.user(JwtService.BEARER + jwt));
    }


    @Test
    void test_roles() throws JwtException {
        List<String> roleList = this.jwtService.roles(JwtService.BEARER + this.jwtToken);
        assertArrayEquals(new String[]{"ADMIN"}, roleList.toArray());
    }
}