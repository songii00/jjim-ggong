package com.api.jjimggong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.telegram.telegrambots.ApiContextInitializer;


@SpringBootApplication
@EnableFeignClients
public class JjimggongApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(JjimggongApplication.class, args);
    }
}


