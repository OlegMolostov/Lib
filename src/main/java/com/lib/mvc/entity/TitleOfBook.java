package com.lib.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "title_of_book")
public class TitleOfBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_of_book_id")
    private int titleOfBookId;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "authors_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public TitleOfBook() {
    }

    public TitleOfBook(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public int getTitleOfBookId() {
        return titleOfBookId;
    }

    public void setTitleOfBookId(int titleOfBookId) {
        this.titleOfBookId = titleOfBookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
