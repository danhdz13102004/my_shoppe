package com.example.mvcdemo.dao;

import com.example.mvcdemo.enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
