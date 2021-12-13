package com.lib.mvc.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy=false)
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genreId;

    @Column(name = "type_genre")
    private String typeGenre;

    public Genre() {
    }

    public Genre(String typeGenre) {
        this.typeGenre = typeGenre;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getTypeGenre() {
        return typeGenre;
    }

    public void setTypeGenre(String typeGenre) {
        this.typeGenre = typeGenre;
    }
}
