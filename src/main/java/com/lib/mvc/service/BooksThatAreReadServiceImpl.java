package com.lib.mvc.service;

import com.lib.mvc.dao.BooksThatAreReadDao;
import com.lib.mvc.entity.BooksThatAreRead;
import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.TitleOfBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksThatAreReadServiceImpl implements BooksThatAreReadService{

    @Autowired
    BooksThatAreReadDao booksThatAreReadDao;


    @Override
    public List<BooksThatAreRead> getAllByProfile(Profile profile) {
        return booksThatAreReadDao.getAllByProfile(profile);
    }

    @Override
    @Transactional
    public void deleteByTitleOfBookTitleOfBookId(int id) {
        booksThatAreReadDao.deleteByTitleOfBookTitleOfBookId(id);
    }

    @Override
    public boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID, int ProfileID) {
        return booksThatAreReadDao.existsByTitleOfBookTitleOfBookIdAndProfileUserId(TitleID,ProfileID);
    }

    @Override
    @Transactional
    public void save(BooksThatAreRead booksThatAreRead) {
        if (existsByTitleOfBookTitleOfBookIdAndProfileUserId(booksThatAreRead.getTitleOfBook().getTitleOfBookId(),booksThatAreRead.getProfile().getUserId())){
            return;
        }
        booksThatAreReadDao.save(booksThatAreRead);
    }

    @Override
    public long count() {
        return booksThatAreReadDao.count();
    }


}
