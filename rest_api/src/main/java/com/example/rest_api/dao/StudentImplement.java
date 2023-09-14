package com.example.rest_api.dao;

import com.example.rest_api.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentImplement implements InterfaceDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Student> findAll() {
        String jpql = "SELECT s from Student s";
        return this.entityManager.createQuery(jpql,Student.class).getResultList();
    }

    @Override
    public Student getById(int id) {
        return this.entityManager.find(Student.class,id);
    }

    @Override
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public void saveAndFlush(Student student) {
        this.entityManager.merge(student);
        entityManager.flush();
    }

    @Override
    public void deleteById(int id) {
        Student sv = this.getById(id);
        if(sv != null) {
            this.entityManager.remove(sv);
        }

    }

}
