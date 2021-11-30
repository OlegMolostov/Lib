package com.lib.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "favorite_books")
public class FavoriteBooks {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_books_id")
    private int FavoriteBooksId;

    @ManyToOne
    @JoinColumn(name = "title_of_book_id")
    private TitleOfBook titleOfBook;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Profile profile;

    public FavoriteBooks() {
    }

    public FavoriteBooks(TitleOfBook titleOfBook, Profile profile) {
        this.titleOfBook = titleOfBook;
        this.profile = profile;
    }

    public int getFavoriteBooksId() {
        return FavoriteBooksId;
    }

    public void setFavoriteBooksId(int favoriteBooksId) {
        FavoriteBooksId = favoriteBooksId;
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
