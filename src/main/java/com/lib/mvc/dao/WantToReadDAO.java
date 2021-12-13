package com.lib.mvc.dao;

import com.lib.mvc.entity.Profile;

import com.lib.mvc.entity.WantToRead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WantToReadDAO extends JpaRepository<WantToRead,Integer> {
    List<WantToRead> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);
}
