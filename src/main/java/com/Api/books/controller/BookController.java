package com.Api.books.controller;

import com.Api.books.Error.BookError;
import com.Api.books.model.Books;
import com.Api.books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
   public Books addBook(@Valid @RequestBody Books book){
        return bookService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Books> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Books getBooKById(@PathVariable("id") Long book_id) throws BookError {
        return bookService.getBookById(book_id);
    }
    @DeleteMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable("id") Long book_id){
        bookService.deleteBook(book_id);
        return "Book deleted successfully";
    }
    @PutMapping("/update-book/{id}")
    public Books  updateBook(@PathVariable("id") Long book_id, @RequestBody Books book){
      return bookService.updateBook(book_id,book);
    }

}
