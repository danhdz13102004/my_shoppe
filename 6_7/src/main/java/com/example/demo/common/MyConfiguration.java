package com.example.demo.common;

import com.example.demo.DAO.SvDAO;
import com.example.demo.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration

public class MyConfiguration {
    @Bean
    @Autowired
    public CommandLineRunner getRunner(SvDAO svDAO) {
        return runner -> {
            Scanner sc = new Scanner(System.in);
            svDAO.save(new SinhVien("a","b","c"));
        };
    }
}
