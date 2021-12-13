package com.lib.mvc.service;


import com.lib.mvc.entity.FavoriteBooks;
import com.lib.mvc.entity.Profile;

import java.util.List;

public interface FavoriteBooksService {
    List<FavoriteBooks> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);
    void save(FavoriteBooks favoriteBooks);
    long count();
}
