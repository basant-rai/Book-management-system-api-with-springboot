package com.Api.books.controller;

import com.Api.books.exception.UserNotFoundException;
import com.Api.books.model.Author;
import com.Api.books.model.User;
import com.Api.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    @GetMapping("/get-authors")
    List<Author> getAuthors(){
        return authorRepository.findAll();
    }
    @GetMapping("/get-author/{id}")
    Author getAuthorById(@PathVariable Long id){
        return authorRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PostMapping("/add-author")
    Author addAuthor(@RequestBody Author newAuthor){
        return authorRepository.save(newAuthor);
    }

//    @PutMapping("/update-author/{id}")
//     Author updateAuthor(@RequestBody Author update_author, @PathVariable Long id){
//        return authorRepository.findById(id)
//                .map(user ->{
//                    user.setAuthor_name(update_author.getAuthor_name());
//
//                })
//                .orElseThrow(()->new UserNotFoundException(id));
//    }
}
