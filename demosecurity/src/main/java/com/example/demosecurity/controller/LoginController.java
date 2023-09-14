package com.example.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @GetMapping()
    public String showHomePage(Model model) {
        return "home";
    }
    @GetMapping("/showLoginPage")
    public String showLogin() {
        return "login";
    }
    @GetMapping("/showPage403")
    public String show403() {
        return "error/page403";
    }
    @GetMapping("/admin")
    public String toAdmin() {
        return "admin";
    }
    @GetMapping("/manager")
    public String toManager() {
        return "manager";
    }

}
