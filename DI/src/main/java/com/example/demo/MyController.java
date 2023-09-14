package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MailSV;
import service.MsgInterface;

@RestController
public class MyController {
    private MsgInterface email;
    private MsgInterface zalo;
    @Autowired
    public void  setEmail(@Qualifier("mailSV") MsgInterface email) {
        this.email = email;
    }
    @Autowired
    public void setZalo(@Qualifier("mailZalo") MsgInterface zalo) {
        this.zalo = zalo;
    }
    @GetMapping("/email")
    public String sendMail() {
        return this.email.sendEmail();
    }
    @GetMapping("/zalo")
    public String sendMail1() {
        return this.zalo.sendEmail();
    }
    @GetMapping("/")
    public String sendMenu() {return this.email.sendMenu(); }
}
