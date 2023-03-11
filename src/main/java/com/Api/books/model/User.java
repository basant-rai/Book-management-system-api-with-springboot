package com.Api.books.model;

import jakarta.persistence.*;

@Entity
//This is used to create table name or is auto
//@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
//    Is is for adding colum name or use declare name
//    @Column(name="first_name")
    private String first_name;
    private String last_name;
    private String address;
    private Long phone_number;
    private String email;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId (){
        return id;
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
