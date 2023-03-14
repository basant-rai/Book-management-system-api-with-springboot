package com.Api.books.service;

import com.Api.books.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    public User addUser(User user);

    public User updateUser(Long id,User user);

}
