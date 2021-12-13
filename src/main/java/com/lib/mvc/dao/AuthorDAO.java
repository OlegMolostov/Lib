package com.lib.mvc.dao;

import com.lib.mvc.entity.*;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuthorDAO extends JpaRepository<Author,Integer> {
    Author getById(Integer id);


}
