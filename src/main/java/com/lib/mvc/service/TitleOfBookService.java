package com.lib.mvc.service;

import com.lib.mvc.entity.TitleOfBook;

import java.util.List;

public interface TitleOfBookService {
    List<TitleOfBook> getAllBy();
    List<TitleOfBook> getAllByAuthorAuthorId(int id);
    TitleOfBook getByTitleOfBookId(int id);
    List<TitleOfBook> findByTitleContainsAndAuthorSurnameContainsAndGenreTypeGenreContains(String title,String surname,String genre);
}
