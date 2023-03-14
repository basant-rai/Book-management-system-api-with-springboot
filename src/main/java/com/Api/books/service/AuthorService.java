package com.Api.books.service;

import com.Api.books.model.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> getAllAuthors();

    public Author saveAuthor(Author author);

}
