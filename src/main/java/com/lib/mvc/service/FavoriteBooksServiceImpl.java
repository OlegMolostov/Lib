package com.lib.mvc.service;


import com.lib.mvc.dao.FavoriteBooksDAO;
import com.lib.mvc.entity.FavoriteBooks;
import com.lib.mvc.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavoriteBooksServiceImpl implements FavoriteBooksService{

    @Autowired
    FavoriteBooksDAO favoriteBooksDAO;

    @Override
    public List<FavoriteBooks> getAllByProfile(Profile profile) {
        return favoriteBooksDAO.getAllByProfile(profile);
    }

    @Override
    @Transactional
    public void deleteByTitleOfBookTitleOfBookId(int id) {
        favoriteBooksDAO.deleteByTitleOfBookTitleOfBookId(id);
    }

    @Override

    public boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID, int ProfileID) {
        return favoriteBooksDAO.existsByTitleOfBookTitleOfBookIdAndProfileUserId(TitleID,ProfileID);
    }

    @Override
    @Transactional
    public void save(FavoriteBooks favoriteBooks) {
        if (existsByTitleOfBookTitleOfBookIdAndProfileUserId(favoriteBooks.getTitleOfBook().getTitleOfBookId(),favoriteBooks.getProfile().getUserId())){
            return;
        }
        favoriteBooksDAO.save(favoriteBooks);
    }

    @Override
    public long count() {
        return favoriteBooksDAO.count();
    }


}
