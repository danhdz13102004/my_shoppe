package com.example.rest_api.dao;

import com.example.rest_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "sinhvien")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameAndLastName(String firstName,String lastName);
    public List<Student> findByFirstNameNot(String firstName);


}


