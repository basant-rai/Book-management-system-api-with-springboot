package com.Api.books.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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
    @OneToOne(targetEntity = Author.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
//    @RestResource(path = "libraryAddress", rel="address")
    private Author  author;

    public Long getBook_id() {
        return book_id;
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
}
