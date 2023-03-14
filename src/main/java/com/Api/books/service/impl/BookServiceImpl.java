package com.Api.books.service.impl;

import com.Api.books.Error.BookError;
import com.Api.books.model.Author;
import com.Api.books.model.Books;
import com.Api.books.repository.AuthorRepository;
import com.Api.books.repository.BookRepository;
import com.Api.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Books saveBook(Books book){
//        Books books = bookRepository.findById(book.getBook_id()).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        Author author = authorRepository.findById(book.getAuthor().getId()).orElseThrow(() -> new EntityNotFoundException("Author not found"));
//        Author author = authorRepository.findById(id).get();
        book.setAuthor(author);

//        book.getAuthor().setAuthor_name(author.getAuthor_name());
        return bookRepository.save(book);
    }

    @Override
    public List<Books> getAllBooks(){
        return bookRepository.findAll();
    }
//        public List<Books> getAllBooks(){
//        List<Books> books=bookRepository.findAll();
//        for(Books book:books){
//            Author author = book.getAuthor_name();
//
//        }
//    }
    
    @Override
    public Books getBookById(Long book_id) throws BookError {
       Optional<Books> book =
               bookRepository.findById(book_id);
       if(!book.isPresent()){
           throw new BookError("Book not found");
       }else{
           return book.get();
       }
    }

    @Override
    public void deleteBook(Long book_id){
        bookRepository.deleteById(book_id);
    }

    @Override
    public Books updateBook(Long book_id,Books book){
//        return bookRepository.findById(book_id)
        Books update_book = bookRepository.findById(book_id).get();
        if(Objects.nonNull(book.getBook_name())&&!"".equalsIgnoreCase(book.getBook_name())){
            update_book.setBook_name(book.getBook_name());
        }
        Author author = authorRepository.findById(book.getAuthor().getId()).orElseThrow(() -> new EntityNotFoundException("Author not found"));

        if (Objects.nonNull(author)) {
            Author existingAuthor = update_book.getAuthor();
            existingAuthor.setId(author.getId());
//            existingAuthor.setPublished_date(author.getPublished_date());
            authorRepository.save(existingAuthor);
        }
        return update_book;
    }
}
