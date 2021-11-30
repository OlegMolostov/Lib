package com.lib.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "read_book")
public class ReadBook {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "read_book_id")
    private int ReadBookId;

    @ManyToOne
    @JoinColumn(name = "title_of_book_id")
    private TitleOfBook titleOfBook;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Profile profile;

    public ReadBook() {
    }

    public ReadBook(TitleOfBook titleOfBook, Profile profile) {
        this.titleOfBook = titleOfBook;
        this.profile = profile;
    }

    public int getReadBookId() {
        return ReadBookId;
    }

    public void setReadBookId(int readBookId) {
        ReadBookId = readBookId;
    }

    public TitleOfBook getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(TitleOfBook titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
