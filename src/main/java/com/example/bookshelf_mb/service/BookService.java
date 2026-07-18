package com.example.bookshelf_mb.service;


import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.model.BookStatus;
import com.example.bookshelf_mb.model.User;
import com.example.bookshelf_mb.repository.BookRepository;
import com.example.bookshelf_mb.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.bookshelf_mb.dto.BookRequest; // NEW

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
private final BookRepository bookRepository;
private final UserRepository userRepository;
public BookService(BookRepository bookRepository, UserRepository userRepository){this.bookRepository=bookRepository;
    this.userRepository = userRepository;
}


    //creating a book/adding a new book
    public Book createBook(BookRequest request, Long ownerId){

        User user = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());

        book.setOwner(user);
        book.setStatus(BookStatus.PURCHASED);
        book.setReadCount(0);
        book.setCreatedAt(LocalDate.now()); //new feature, sets date
        return bookRepository.save(book);


       // if(optionalUser.isEmpty()) {
         //   throw new RuntimeException("User not found");







   // if(optionalUser.isEmpty())
    //{return null;}
   // book.setOwner(optionalUser.get());
    //1book.setStatus(BookStatus.PURCHASED);
    //1book.setReadCount(0);

       //1 return bookRepository.save(book);

}

//see all books
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






    public List<Book> getBooksByUser(Long ownerId){
        return bookRepository.findByOwnerId(ownerId);
    }//searching book using owners id

    public List<Book> searchByTitle(String title){
        return bookRepository.findByTitle(title);
    }


    public List<Book> searchByAuthor(String author){
        return bookRepository.findByAuthor(author);

          }
    public List<Book> getBooksByStatus(BookStatus status) {
        return bookRepository.findByStatus(status);
    }

    public int getReadCount(Long ownerId){
    return bookRepository.findByReadCount(ownerId); //change made to find counter of user
    }


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
//function to get all books

}
