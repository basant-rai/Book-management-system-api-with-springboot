package com.Api.books.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
//This is used to create table name or is auto
//@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    Is is for adding colum name or use declare name
//    @Column(name="first_name")
    private String first_name;
    private String last_name;
    private String address;
    private Long phone_number;
    private String email;

//    @JsonIgnore
    @ManyToMany(targetEntity = Books.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Set<Books> books =new HashSet<Books>();

    public void setId(Long id){
        this.id = id;
    }
    public Long getId (){
        return id;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
