package com.lib.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "want_to_read")
public class WantToRead {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "want_to_read_id")
    private int WantToReadId;

    @ManyToOne
    @JoinColumn(name = "title_of_book_id")
    private TitleOfBook titleOfBook;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Profile profile;

    public WantToRead() {
    }

    public WantToRead(TitleOfBook titleOfBook, Profile profile) {
        this.titleOfBook = titleOfBook;
        this.profile = profile;
    }

    public int getWantToReadId() {
        return WantToReadId;
    }

    public void setWantToReadId(int wantToReadId) {
        WantToReadId = wantToReadId;
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
