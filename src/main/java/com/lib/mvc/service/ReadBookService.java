package com.lib.mvc.service;

import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.ReadBook;

import java.util.List;

public interface ReadBookService {
    List<ReadBook> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);
    void save(ReadBook readBook);
    long count();

}
