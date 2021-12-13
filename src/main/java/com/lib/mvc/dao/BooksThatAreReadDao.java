package com.lib.mvc.dao;

import com.lib.mvc.entity.BooksThatAreRead;
import com.lib.mvc.entity.Profile;
import com.lib.mvc.entity.TitleOfBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksThatAreReadDao extends JpaRepository<BooksThatAreRead,Integer> {

    List<BooksThatAreRead> getAllByProfile(Profile profile);
    void deleteByTitleOfBookTitleOfBookId(int id);
    boolean existsByTitleOfBookTitleOfBookIdAndProfileUserId(int TitleID,int ProfileID);

}
