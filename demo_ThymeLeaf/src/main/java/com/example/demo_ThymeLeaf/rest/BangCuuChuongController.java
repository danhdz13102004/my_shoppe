package com.example.demo_ThymeLeaf.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BangCuuChuongController {

    @GetMapping("/hien-thi/{x}")
    public String hienThiBangCuuChuong(@PathVariable int x, Model model) {
        model.addAttribute("number" , x);
        return "bang-cuu-chuong";
    }
}
