package com.lib.mvc.service;

import com.lib.mvc.entity.BooksThatAreRead;
import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.TitleOfBook;

import java.util.List;

public interface BooksThatAreReadService {
    List<BooksThatAreRead> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);
    void save(BooksThatAreRead booksThatAreRead);
    long count();
}
