package com.example.bookshelf_mb.repository;


import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.model.BookStatus;
import com.example.bookshelf_mb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByOwnerId(Long ownerId);
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByStatus(BookStatus status);

}
