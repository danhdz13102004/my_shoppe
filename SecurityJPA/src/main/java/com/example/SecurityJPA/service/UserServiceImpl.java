package com.example.SecurityJPA.service;

import com.example.SecurityJPA.dao.RoleRepository;
import com.example.SecurityJPA.dao.UserRepository;
import com.example.SecurityJPA.entity.Role;
import com.example.SecurityJPA.entity.User;
import jakarta.annotation.PostConstruct;
import org.apache.tomcat.util.net.jsse.JSSEImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
//    @PostConstruct
//    public void insertUser() {
//        User user = new User();
//        user.setUserName("danhdz1310");
//        user.setPassWord("{bcrypt}$2a$12$ebzaist3A.EQwMQVKFP7QOAhT.L3JuA.GnOFITJBb.g0tugQDCH3.");
//        user.setEnalble(true);
//        Role role1 = new Role();
//        role1.setName("ROLE_ADMIN");
//        Collection<Role> list = new ArrayList<>();
//        list.add(role1);
//        user.setRoles(list);
//        userRepository.save(user);
//
//    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void save(User user) {
            userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(username == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassWord(),rolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
