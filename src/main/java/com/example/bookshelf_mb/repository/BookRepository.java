package com.example.bookshelf_mb.repository;


import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
}
