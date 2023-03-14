package com.Api.books.controller;

import com.Api.books.model.Author;
import com.Api.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("/authors")
   public List<Author> getAuthors()
    {
        return authorService.getAllAuthors();
    }

    @PostMapping("/author")
    public Author addAuthor(@Validated @RequestBody Author author){
        return authorService.saveAuthor(author);
    }



//    @GetMapping("/get-author/{id}")
//    Author getAuthorById(@PathVariable Long id){
//        return authorRepository.findById(id)
//                .orElseThrow(()->new UserNotFoundException(id));
//    }
//
//    @PostMapping("/add-author")
//    Author addAuthor(@RequestBody Author newAuthor){
//        return authorRepository.save(newAuthor);
//    }

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
