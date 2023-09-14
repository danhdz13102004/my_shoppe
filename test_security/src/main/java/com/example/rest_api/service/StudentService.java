package com.example.rest_api.service;

import com.example.rest_api.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();

    public Student getById(int id);

    public void save(Student student);

    public void saveAndFlush(Student student);
    public void deleteById(int id);
    public List<Student> getAllStudentNotFirstName(String name);

    public List<Student> findByFirstNameNotContaining(String name);
}
