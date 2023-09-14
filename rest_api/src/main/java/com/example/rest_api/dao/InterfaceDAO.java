package com.example.rest_api.dao;

import com.example.rest_api.entity.Student;

import java.util.List;

public interface InterfaceDAO {
    public List<Student> findAll();

    public Student getById(int id);

    public void save(Student student);

    public void saveAndFlush(Student student);
    public void deleteById(int id);
}
