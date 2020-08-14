package com.dulcepan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dulcepan.dao")
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan({"com.dulcepan.*"})
@EntityScan(basePackages = "com.dulcepan.entity")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
