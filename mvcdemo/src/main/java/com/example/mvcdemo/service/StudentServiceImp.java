package com.example.mvcdemo.service;


import com.example.mvcdemo.dao.StudentRepository;
import com.example.mvcdemo.enitity.Student;
import com.example.mvcdemo.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImp( StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void saveAndFlush(Student student) {
        studentRepository.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
