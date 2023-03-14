package com.Api.books.controller;

import com.Api.books.exception.UserNotFoundException;
import com.Api.books.model.User;
import com.Api.books.repository.UserRepository;
import com.Api.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update-user/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

//    @PostMapping("/user")
//    User newUser(@RequestBody User newUser){
//        return userRepository.save(newUser);
//    }
//    @GetMapping("/get-users")
//    List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/get-user/{id}")
//    User getUserById(@PathVariable Long id){
//        return userRepository.findById(id)
//                .orElseThrow(()->new UserNotFoundException(id));
//    }
//    @PutMapping("/update-user/{id}")
//    Object updateUser(@RequestBody User newUser,@PathVariable Long id){
//        return userRepository.findById(id)
//                .map(user -> {
//                    user.setFirst_name(newUser.getFirst_name());
//                    user.setLast_name(newUser.getLast_name());
//                    user.setAddress((newUser.getAddress()));
//                    user.setPhone_number((newUser.getPhone_number()));
//                    return null;
//                })
//                .orElseThrow(()->new UserNotFoundException(id));
//    }
//
//    @DeleteMapping("/delete-user/{id}")
//    String deleteUser(@PathVariable Long id){
//        if(!userRepository.existsById(id)){
//            throw new UserNotFoundException(id);
//        }
//        userRepository.deleteById(id);
//        return "User has been deleted successfully";
//    }

}
