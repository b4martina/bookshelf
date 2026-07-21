package com.example.bookshelf_mb.repository;


import com.example.bookshelf_mb.dto.UserBooksResponse;
import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.model.BookStatus;
import com.example.bookshelf_mb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByOwnerId(Long ownerId);
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByStatus(BookStatus status);

@Query(
       nativeQuery = true,
        value =
        "SELECT COUNT(id) FROM books where owner_id = :ownerId and status = 'READ'")
      int findByReadCount(@Param("ownerId") Long ownerId);
//new change to get read books
@Query (
        nativeQuery=true,
        value="SELECT * from books where status='READ'")
    UserBooksResponse findByReadBooks(@Param("bookStatus") BookStatus bookStatus);

@Query (nativeQuery=true,
        value="Select * from books where owner_id= :ownerId and status='READ'" )
List<Book> findReadBooksOfUser(@Param("ownerId") Long ownerId);

}


