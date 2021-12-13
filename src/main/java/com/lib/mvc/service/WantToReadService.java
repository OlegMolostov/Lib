package com.lib.mvc.service;

import com.lib.mvc.entity.BooksThatAreRead;
import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.WantToRead;

import java.util.List;

public interface WantToReadService {
    List<WantToRead> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);
    void save(WantToRead wantToRead);
    long count();
}
