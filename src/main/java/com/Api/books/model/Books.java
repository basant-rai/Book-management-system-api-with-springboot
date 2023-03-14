package com.Api.books.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
//lombok is used to remove boiler code lik getter setter constructor
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder run while in build time
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    @NotBlank(message= "Please add book name")
//    @Length(max=5,min=2)
//    @Email
//    @Positive

    private String book_name;
    private String published_date;
    @ManyToOne(targetEntity = Author.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
//    @RestResource(path = "libraryAddress", rel="address")
    private Author  author;

   @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = User.class,cascade = CascadeType.ALL,mappedBy = "books")
    private Set<User> users =new HashSet<User>();


    public Long getBook_id() {
        return book_id;
    }

//    public Books(Long book_id, String book_name, String published_date) {
//        this.book_id = book_id;
//        this.book_name = book_name;
//        this.published_date = published_date;
//    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }
}
