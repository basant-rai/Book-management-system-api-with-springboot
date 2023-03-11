package com.Api.books.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
    private String author_name;

//

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

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
