package com.example.mvcdemo.controller;


import com.example.mvcdemo.enitity.Student;
import com.example.mvcdemo.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/list")
    public String listAll(Model model) {
            List<Student> students = studentService.findAll();
            model.addAttribute("students",students);
            return "student/Students";
    }
    @GetMapping("/create")
    public String toCreateForm(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "student/students-form";
    }
    @GetMapping("/update")
    public String toUpdateForm(@RequestParam("id") Integer id, Model model) {
        Student student = new Student();
        System.out.println(student);
        model.addAttribute("student",student);
        model.addAttribute("id",id);
        return "student/form-update";
    }
    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") Integer id) {
        studentService.deleteById(id);
        return "redirect:/students/list";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        System.out.println(student);
        studentService.saveAndFlush(student);
        return "redirect:/students/list";
    }
    @PostMapping("/updates")
    public String update(@RequestParam("id") Integer id, @ModelAttribute("student") Student student) {
        student.setId(id);
        System.out.println(student);
        System.out.println(student  );
        studentService.saveAndFlush(student);
        return "redirect:/students/list";
    }




}
