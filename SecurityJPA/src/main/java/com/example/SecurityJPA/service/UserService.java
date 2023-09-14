package com.example.SecurityJPA.service;

import com.example.SecurityJPA.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsername(String user);

    public void save(User user);

}
