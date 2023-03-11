package com.Api.books.service;

import com.Api.books.Error.BookError;
import com.Api.books.model.Books;

import java.util.List;

public interface BookService {
   public Books saveBook(Books book);
   public List<Books> getAllBooks();
   public Books getBookById(Long book_id) throws BookError;
   public void deleteBook(Long book_id);

   public Books updateBook(Long book_id,Books book);
}
