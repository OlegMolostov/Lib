package com.lib.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.lib.mvc.entity.TitleOfBook;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileDAOImpl implements ProfileDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TitleOfBook> getAllTitleTheOfBook() {

        Session session=sessionFactory.getCurrentSession();
        List<TitleOfBook> allTitleOfBook=session.createQuery("from TitleOfBook",TitleOfBook.class)
                .getResultList();
        return allTitleOfBook;
    }
}
