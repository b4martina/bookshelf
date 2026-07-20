package com.example.bookshelf_mb.controllers;

import com.example.bookshelf_mb.dto.UserBooksResponse;
import com.example.bookshelf_mb.model.User;
import com.example.bookshelf_mb.repository.UserRepository;
import com.example.bookshelf_mb.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;
    public UserController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

@GetMapping
public List<User> getAllUsers (){
 return  userService.getAllUsers();

}

@GetMapping ("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
}

@PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser (id, user);
}

@DeleteMapping ("/{id}")
    public void deleteUser(@PathVariable Long id){
userService.deleteUser(id);
    }



//last change after ubr and service
    @GetMapping("/all-books")
    public List<UserBooksResponse> getUsersWithBooks(){
        return userService.getUsersWithBooks();
    }

}
