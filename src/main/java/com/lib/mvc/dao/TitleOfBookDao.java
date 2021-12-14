package com.lib.mvc.dao;

import com.lib.mvc.entity.Author;
import com.lib.mvc.entity.TitleOfBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleOfBookDao extends JpaRepository<TitleOfBook, Integer> {

     List<TitleOfBook> getAllBy();
     List<TitleOfBook> getAllByAuthorAuthorId(int id);
     TitleOfBook getByTitleOfBookId(int id);

     List<TitleOfBook> findByTitleContainsAndAuthorSurnameContainsAndGenreTypeGenreContains(String title,String surname,String genre);



}
