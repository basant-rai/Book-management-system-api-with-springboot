package com.Api.books.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    private Long id;
    private String author_name;
    private String published_date;


    public Author(Long id, String author_name, String published_date) {
        this.id = id;
        this.author_name = author_name;
        this.published_date = published_date;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getAuthor_name(){
        return author_name;
    }
    public void setAuthor_name(String author_name){
        this.author_name= author_name;
    }
    public String getPublished_date(){
        return published_date;
    }
    public void setPublished_date(String published_date){
        this.published_date = published_date;

    }

}
