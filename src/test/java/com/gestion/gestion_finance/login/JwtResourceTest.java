package com.gestion.gestion_finance.login;

import com.dulcepan.api.JwtApi;
import com.gestion.gestion_finance.ApiTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;
@ApiTestConfig
public class JwtResourceTest {

    @Autowired
    private WebTestClient testClient;

    private String jwt;

    @BeforeEach
    void login() {
        this.jwt = testClient
                .mutate().filter(basicAuthentication("gsolis", "12345")).build()
                .post().uri(JwtApi.JWT + JwtApi.TOKEN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();
    }

    @Test
    void test_get_token_not_null() {
        System.out.println(this.jwt);
        assertNotNull(this.jwt);
    }

    @Test
    void test_get_token_not_auth_basic() {
        testClient
                .post().uri(JwtApi.JWT + JwtApi.TOKEN)
                .exchange()
                .expectStatus().isUnauthorized();
    }


    @Test
    void test_verify_token_ok() {
        testClient
                .get().uri(JwtApi.JWT)
                .header("Authorization", "Bearer " + this.jwt)
                .exchange()
                .expectStatus().isOk();
    }
}