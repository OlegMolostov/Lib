package com.lib.mvc.service;

import com.lib.mvc.dao.ReadBookDAO;
import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.ReadBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadBookServiceImpl implements ReadBookService{

    @Autowired
    ReadBookDAO readBookDAO;

    @Override
    public List<ReadBook> getAllByProfile(Profile profile) {
        return readBookDAO.getAllByProfile(profile);
    }

    @Override
    @Transactional
    public void deleteByTitleOfBookTitleOfBookId(int id) {
        readBookDAO.deleteByTitleOfBookTitleOfBookId(id);
    }

    @Override
    public boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID, int ProfileID) {
        return readBookDAO.existsByTitleOfBookTitleOfBookIdAndProfileUserId(TitleID,ProfileID);
    }

    @Override
    @Transactional
    public void save(ReadBook readBook) {
        if (existsByTitleOfBookTitleOfBookIdAndProfileUserId(readBook.getTitleOfBook().getTitleOfBookId(),readBook.getProfile().getUserId())){
            return;
        }
        readBookDAO.save(readBook);
    }

    @Override
    public long count() {
        return readBookDAO.count();
    }
}
