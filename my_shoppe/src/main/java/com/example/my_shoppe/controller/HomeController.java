package com.example.my_shoppe.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String toHome() {
        return "idx";
    }
    @GetMapping("/home")
    public String toHome1() {
        return "idx";
    }

}
