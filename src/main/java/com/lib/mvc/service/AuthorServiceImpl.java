package com.lib.mvc.service;

import com.lib.mvc.dao.AuthorDAO;
import com.lib.mvc.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorDAO authorDAO;

    @Override
    @Transactional
    public Author getById(int id) {
        return authorDAO.getById(id);
    }
}
