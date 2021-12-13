package com.lib.mvc.service;

import com.lib.mvc.dao.WantToReadDAO;
import com.lib.mvc.entity.BooksThatAreRead;
import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.WantToRead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WantToReadServiceImpl implements WantToReadService{

    @Autowired
    WantToReadDAO wantToReadDAO;

    @Override
    public List<WantToRead> getAllByProfile(Profile profile) {
        return wantToReadDAO.getAllByProfile(profile);
    }

    @Override
    @Transactional
    public void deleteByTitleOfBookTitleOfBookId(int id) {
        wantToReadDAO.deleteByTitleOfBookTitleOfBookId(id);
    }

    @Override
    public boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID, int ProfileID) {
        return wantToReadDAO.existsByTitleOfBookTitleOfBookIdAndProfileUserId(TitleID,ProfileID);
    }

    @Override
    @Transactional

    public void save(WantToRead wantToRead) {
        if (existsByTitleOfBookTitleOfBookIdAndProfileUserId(wantToRead.getTitleOfBook().getTitleOfBookId(),wantToRead.getProfile().getUserId())){
            return;
        }
        wantToReadDAO.save(wantToRead);
    }

    @Override
    public long count() {
        return wantToReadDAO.count();
    }
}
