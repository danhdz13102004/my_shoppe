package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Service {
    @Bean
    public Calculator getCon() {
        return new Calculator();
    }
}
