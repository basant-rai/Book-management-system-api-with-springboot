package com.Api.books.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author_name;
    @OneToOne(mappedBy = "author")
    private Books book;
    private String published_date;


    public Author() {
    }

    public Author(Long id, String author_name, String published_date) {
        this.id = id;
        this.author_name = author_name;
//        this.book = book;
        this.published_date = published_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

//    public Books getBook() {
//        return book;
//    }
//
//    public void setBook(Books book) {
//        this.book = book;
//    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }
}
