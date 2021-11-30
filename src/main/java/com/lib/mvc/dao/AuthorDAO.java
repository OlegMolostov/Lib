package com.lib.mvc.dao;

import com.lib.mvc.entity.*;

import java.util.List;


public interface AuthorDAO {
    public Author getAuthor(int id);

    public List<TitleOfBook> getTitleOfBookList(int id);
}
