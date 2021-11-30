package com.lib.mvc.dao;

import com.lib.mvc.entity.Author;
import com.lib.mvc.entity.TitleOfBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Author getAuthor(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Author.class,id);
    }

    @Override
    public List<TitleOfBook> getTitleOfBookList(int id) {
        Session session=sessionFactory.getCurrentSession();
       List<TitleOfBook> titleOfBookList=session.createQuery(" from TitleOfBook where author.authorId='"+id+"'").
               getResultList();
        return titleOfBookList;
    }
}
