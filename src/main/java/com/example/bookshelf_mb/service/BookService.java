package com.example.bookshelf_mb.service;


import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.model.BookStatus;
import com.example.bookshelf_mb.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
private final BookRepository bookRepository;

public BookService(BookRepository bookRepository){this.bookRepository=bookRepository;}


    //creating a book/adding a new book
    public Book createBook(Book book){
book.setStatus(BookStatus.PURCHASED);
book.setReadCount(0);

        return bookRepository.save(book);

}


//see all books
public List<Book> getAllBooks(){
    return bookRepository.findAll();
}

//get one book
public Optional<Book> getBookById(Long id){
    return bookRepository.findById(id);

}

//update the book
public Book updateBook(Long id, Book updateBook){
    Optional <Book> optionalBook= bookRepository.findById(id);

    if (optionalBook.isPresent()){
        Book book= optionalBook.get();

        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
       // book.setQuantity(updateBook.getTitle());
        book.setStatus(updateBook.getStatus());
        book.setReadCount(updateBook.getReadCount());

        return bookRepository.save(book);


    }
    return null;
}

//how to delete a book
public void deleteBook(Long id){
    bookRepository.deleteById(id);
}

    public Book markAsRead(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {

            Book book = optionalBook.get();

            book.setStatus(BookStatus.READ);
            book.setReadCount(book.getReadCount() + 1);

            return bookRepository.save(book);
        }

        return null;
    }

//removing a book from the bookshelf
    public Book removeBook(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {

            Book book = optionalBook.get();

            book.setStatus(BookStatus.REMOVED);

            return bookRepository.save(book);
        }

        return null;
    }

}
