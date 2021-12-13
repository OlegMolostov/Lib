package com.lib.mvc.dao;


import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.ReadBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadBookDAO extends JpaRepository<ReadBook,Integer> {

    List<ReadBook> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);
}
