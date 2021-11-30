package com.lib.mvc.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authors_id")
    private int authorId;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "secondname")
    private  String secondname;

    @Column(name = "short_biography")
    private String shortBiography;


    @OneToMany(mappedBy = "author")
    private List<TitleOfBook> titleOfBookList;


    public Author() {
    }

    public Author(String surname, String name, String secondname, String shortBiography) {

        this.surname = surname;
        this.name = name;
        this.secondname = secondname;
        this.shortBiography = shortBiography;
    }

    public List<TitleOfBook> getTitleOfBookList() {
        return titleOfBookList;
    }

    public void setTitleOfBookList(List<TitleOfBook> titleOfBookList) {
        this.titleOfBookList = titleOfBookList;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getShortBiography() {
        return shortBiography;
    }

    public void setShortBiography(String shortBiography) {
        this.shortBiography = shortBiography;
    }
}
