package com.example.rest_api.dao;

import com.example.rest_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameAndLastName(String firstName,String lastName);

//    public List<Student> findByFirstNameNot(String firstName);
    @Query("SELECT s from Student s where  s.firstName<>?1")
    public List<Student> findByFirstNameNot(String firstName);

//    @Query("SELECT s from  Student s  where  s.firstName NOT LIKE %?1%")
//    public List<Student> findByFirstNameNotContaining(String firstName);

    public List<Student> findByFirstNameNotContaining(String firstName);

}
