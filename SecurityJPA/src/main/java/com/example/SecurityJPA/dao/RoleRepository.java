package com.example.SecurityJPA.dao;

import com.example.SecurityJPA.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
        public Role findByName(String name);
}
