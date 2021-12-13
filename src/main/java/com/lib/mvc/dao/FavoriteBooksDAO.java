package com.lib.mvc.dao;

import com.lib.mvc.entity.BooksThatAreRead;
import com.lib.mvc.entity.FavoriteBooks;
import com.lib.mvc.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteBooksDAO extends JpaRepository<FavoriteBooks,Integer> {
    List<FavoriteBooks> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);
}
