package com.example.rest_api.service;

import com.example.rest_api.dao.InterfaceDAO;
import com.example.rest_api.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService{
    private InterfaceDAO interfaceDAO;
    @Autowired
    public StudentServiceImp(InterfaceDAO interfaceDAO) {
        this.interfaceDAO = interfaceDAO;
    }

    @Override
    public List<Student> findAll() {
        return interfaceDAO.findAll();
    }

    @Override
    public Student getById(int id) {
        return interfaceDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(Student student) {
        interfaceDAO.save(student);
    }

    @Override
    @Transactional
    public void saveAndFlush(Student student) {
        interfaceDAO.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        interfaceDAO.deleteById(id);
    }
}
