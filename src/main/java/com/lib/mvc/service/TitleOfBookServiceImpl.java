package com.lib.mvc.service;

import com.lib.mvc.dao.TitleOfBookDao;
import com.lib.mvc.entity.TitleOfBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TitleOfBookServiceImpl implements TitleOfBookService{

    @Autowired
    TitleOfBookDao titleOfBookDao;

    @Override
    @Transactional(readOnly = true)
    public List<TitleOfBook> getAllBy() {
        return titleOfBookDao.getAllBy();
    }

    @Override
    public List<TitleOfBook> getAllByAuthorAuthorId(int id) {
        return titleOfBookDao.getAllByAuthorAuthorId(id);
    }

    @Override
    @Transactional
    public TitleOfBook getByTitleOfBookId(int id) {
        return titleOfBookDao.getByTitleOfBookId(id);
    }

    @Override
    public List<TitleOfBook> findByTitleContainsAndAuthorSurnameContainsAndGenreTypeGenreContains(String title, String surname, String genre) {
        return titleOfBookDao.findByTitleContainsAndAuthorSurnameContainsAndGenreTypeGenreContains(title,surname,genre);
    }
}
