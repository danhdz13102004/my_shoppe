package com.example.mvcdemo.service;

import com.example.mvcdemo.enitity.Student;
import java.util.List;

public interface StudentService {
    public List<Student> findAll();

    public Student getById(int id);

    public void save(Student student);

    public void saveAndFlush(Student student);
    public void deleteById(int id);
}
