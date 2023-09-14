package com.example.SecurityJPA.dao;

import com.example.SecurityJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserName(String username);
    public User findByEmail(String email);
}
