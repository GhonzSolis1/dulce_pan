package com.pasteleria;

import com.pasteleria.restController.JwtResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;
@ApiTestConfig
public class JwtResourceTest {

    @Autowired
    private WebTestClient webTestClient;

    private String jwt;

    @BeforeEach
    void login() {
        this.jwt = webTestClient
                .mutate().filter(basicAuthentication("gsolis", "12345")).build()
                .post().uri(JwtResource.JWTS + JwtResource.TOKEN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();
    }

    @Test
    void test_get_token_not_null() {
        assertNotNull(this.jwt);
    }

    @Test
    void test_get_token_not_auth_basic() {
        webTestClient
                .post().uri(JwtResource.JWTS + JwtResource.TOKEN)
                .exchange()
                .expectStatus().isUnauthorized();
    }


    @Test
    void test_verify_token_ok() {
        webTestClient
                .get().uri(JwtResource.JWTS)
                .header("Authorization", "Bearer " + this.jwt)
                .exchange()
                .expectStatus().isOk();
    }

}