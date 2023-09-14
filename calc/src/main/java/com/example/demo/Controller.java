package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Calculator calc;

    public Controller(Calculator calc) {
        this.calc = calc;
    }

    @GetMapping("/")
    public String get() {
        return "Can bac 2 cua 4 :" + calc.canBacHai(4) ;
    }
}
