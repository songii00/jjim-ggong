package com.api.jjimggong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class JjimggongApplication {

    public static void main(String[] args) {
        SpringApplication.run(JjimggongApplication.class, args);

        }
    }


