package com.lib.mvc.service;

import com.lib.mvc.dao.AuthorDAO;
import com.lib.mvc.entity.Author;
import com.lib.mvc.entity.TitleOfBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorDAO authorDAO;


    @Override
    @Transactional
    public Author getAuthor(int id) {
        return authorDAO.getAuthor(id);
    }

    @Override
    @Transactional
    public List<TitleOfBook> getTitleOfBookList(int id) {
        return authorDAO.getTitleOfBookList(id);
    }
}
