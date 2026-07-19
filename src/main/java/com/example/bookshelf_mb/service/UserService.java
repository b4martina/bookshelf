package com.example.bookshelf_mb.service;


import com.example.bookshelf_mb.dto.LogInRequest;
import com.example.bookshelf_mb.dto.UserBooksResponse;
import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.model.User;
import com.example.bookshelf_mb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

 private final UserRepository userRepository;

 public UserService (UserRepository userRepository){
     this.userRepository = userRepository;
 }

public User createUser(User user){
     return userRepository.save(user);

}

public List<User> getAllUsers(){
     return userRepository.findAll();

}
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

public User updateUser(Long id, User updateUser) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {

        User user = optionalUser.get();
        user.setName(updateUser.getName());
        user.setSurname(updateUser.getSurname());
        user.setPassword(updateUser.getPassword());
return userRepository.save(user);

    }
return null;
}

public void deleteUser(Long id){
     userRepository.deleteById(id);
}



//in cse name and surname of someone is the sae, we ask for the password too

    public boolean login(LogInRequest request) {

        Optional<User> optionalUser =
                userRepository.findByNameAndSurname(
                        request.getName(),
                        request.getSurname());

        if(optionalUser.isEmpty()){
            return false;
        }

        User user = optionalUser.get();

        return user.getPassword().equals(request.getPassword());
    }
//change 2 after ubr
    public List<UserBooksResponse> getUsersWithBooks(){
     List<User> users=userRepository.findAll();
     List<UserBooksResponse> userBooksResponses=new ArrayList<>();

for(User user : users)   {
UserBooksResponse ubr = new UserBooksResponse();
ubr.setName(user.getName());
ubr.setSurname(user.getSurname());

List <String> bookTitles = new ArrayList<>();
        for (Book book: user.getBooks()){
            bookTitles.add(book.getTitle());

        }
ubr.setBooks(bookTitles);
        userBooksResponses.add(ubr);


}
return userBooksResponses;
    }

}
