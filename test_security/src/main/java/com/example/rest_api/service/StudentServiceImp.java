package com.example.rest_api.service;

import com.example.rest_api.dao.StudentRepository;
import com.example.rest_api.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService{
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

    @Override
    public List<Student> getAllStudentNotFirstName(String name) {
          return studentRepository.findByFirstNameNot(name);
    }

    @Override
    public List<Student> findByFirstNameNotContaining(String name) {
        return studentRepository.findByFirstNameNotContaining(name);
    }
}
