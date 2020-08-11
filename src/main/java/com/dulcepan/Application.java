package com.dulcepan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dulcepan.dao")
@EnableAutoConfiguration
@ComponentScan({"com.dulcepan.*"})
@EntityScan(basePackages = "com.dulcepan.entity")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
