package com.example.bookshelf_mb.repository;

import com.example.bookshelf_mb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNameAndSurname(String name, String surname);

}
