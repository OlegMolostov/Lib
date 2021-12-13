package com.lib.mvc.service;

import com.lib.mvc.entity.Author;
import com.lib.mvc.entity.TitleOfBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuthorService  {

    Author getById(int id);

}
