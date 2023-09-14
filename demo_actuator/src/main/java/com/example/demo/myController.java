package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {
    private MsgInterface email;
    @Autowired
    public myController(EmailService email) {
        this.email = email;
    }
    @GetMapping("/send")
    public String sendEmail() {
        return this.email.sendMessage();
    }
}
