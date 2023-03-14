package com.Api.books.service.impl;

import com.Api.books.model.Books;
import com.Api.books.model.User;
import com.Api.books.repository.BookRepository;
import com.Api.books.repository.UserRepository;
import com.Api.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User update_user = userRepository.findById(id).get();
//        if(Objects.nonNull(user.getFirst_name())&&!"".equalsIgnoreCase(user.getFirst_name())){
//            update_user.setFirst_name(user.getFirst_name());
//        }
//        Books books = bookRepository.findById(user.getBooks().stream().filter((book)->book.getBook_id())).orElseThrow(() -> new EntityNotFoundException("Author not found"));
        update_user.setFirst_name(user.getFirst_name());
        update_user.setLast_name(user.getLast_name());
        update_user.setAddress((user.getAddress()));
        update_user.setPhone_number((user.getPhone_number()));
//        update_user.setBooks();
//        List<Books> newBooks = new ArrayList<>();
        Set<Books> updateBooks = new HashSet<Books>();;
        for (Books book : user.getBooks()) {
            Books existingBook = bookRepository.findById(book.getBook_id())
                    .orElseThrow(() -> new EntityNotFoundException("Book not found"));
//            newBooks.add(existingBook);
            updateBooks.add(existingBook);
        }
        update_user.setBooks(updateBooks);

        return userRepository.save(update_user);
    }
}
