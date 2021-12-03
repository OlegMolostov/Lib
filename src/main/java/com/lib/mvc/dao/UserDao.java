package com.lib.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lib.mvc.entity.*;



public interface UserDao extends JpaRepository<Profile, Integer> {
    Profile findByEmail(String email);
}