package com.example.customerproject157;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@EnableWebSecurity
public class CustomerProject157Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerProject157Application.class, args);
    }

}
