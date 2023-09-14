package com.example.rest_api.controller;

import com.example.rest_api.dao.InterfaceDAO;
import com.example.rest_api.dao.StudentImplement;
import com.example.rest_api.entity.Student;
import com.example.rest_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAll() {
        return this.studentService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        Student sv = studentService.getById(id);
        if(sv != null) {
            return ResponseEntity.ok(sv);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId(0);
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateById(@PathVariable int id,@RequestBody Student sv) {
        Student student = studentService.getById(id);
        if(student != null) {
            student.setFirstName(sv.getFirstName());
            student.setLastName(sv.getLastName());
            student.setEmail(sv.getEmail());
            studentService.saveAndFlush(student);
            return ResponseEntity.ok(student);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable int id) {
        Student student = studentService.getById(id);
        if(student != null) {
            studentService.deleteById(id);
            return ResponseEntity.ok(student);
        }
            return ResponseEntity.notFound().build();
    }

}
