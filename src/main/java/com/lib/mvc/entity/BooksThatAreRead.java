package com.lib.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "books_that_are_read")
public class BooksThatAreRead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "books_that_are_read_id")
    private int booksThatAreReadId;

    @ManyToOne
    @JoinColumn(name = "title_of_book_id")
    private TitleOfBook titleOfBook;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Profile profile;

    public BooksThatAreRead() {
    }

    public BooksThatAreRead(TitleOfBook titleOfBook, Profile profile) {
        this.titleOfBook = titleOfBook;
        this.profile = profile;
    }

    public int getBooksThatAreReadId() {
        return booksThatAreReadId;
    }

    public void setBooksThatAreReadId(int booksThatAreReadId) {
        this.booksThatAreReadId = booksThatAreReadId;
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
