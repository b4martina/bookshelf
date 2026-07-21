package com.example.bookshelf_mb.controllers;


import com.example.bookshelf_mb.dto.BookRequest;
import com.example.bookshelf_mb.dto.TestBUR;
import com.example.bookshelf_mb.dto.UserBooksResponse;
import com.example.bookshelf_mb.dto.UserFullBookResponse;
import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.model.BookStatus;
import com.example.bookshelf_mb.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/user/{ownerId}")
    public Book createBook(@Valid @RequestBody BookRequest request,
                           @PathVariable Long ownerId) {

        return bookService.createBook(request, ownerId);
    }



   /* @GetMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
*/

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}/read")
    public Book markAsRead(@PathVariable Long id) {
        return bookService.markAsRead(id);
    }

    @PutMapping("/{id}/remove")
    public Book removeBook(@PathVariable Long id) {
        return bookService.removeBook(id);
    }
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @GetMapping("/title")
    public List<Book> title(@RequestParam String title) {
        return bookService.searchByTitle(title);

    }//search by title endpoint title

    @GetMapping("/author")
    public List<Book> author(@RequestParam String author) {
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/status/{status}")
    public List<Book> getBookByStatus(@PathVariable BookStatus status) {
        return bookService.getBooksByStatus(status);
    }

    @GetMapping("/readcount/{ownerId}")
    public int title(@PathVariable Long ownerId) {
        return bookService.getReadCount(ownerId);
    }


    @GetMapping
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/owners")
    public List<UserFullBookResponse> getAllBooksWithUsers(){
        return bookService.getAllBooksWithUsers();
    }








/**@PostMapping("/user/{ownerId}") public Book createBook(@Valid @RequestBody BookRequest request,
 @PathVariable Long ownerId) {

 return bookService.createBook(request, ownerId);
 }**/

/**
 *  @GetMapping("/{id}")
 *     public Optional<Book> getBookById(@PathVariable Long id) {
 *         return bookService.getBookById(id);
 *     }
 */

@GetMapping("/user/{ownerId}")
public List<Book> getBooksByUser(@PathVariable Long ownerId) {
    return bookService.getBooksByUser(ownerId);
}



@GetMapping("/find-user/{id}")
    public TestBUR getTestBUR(@PathVariable Long id){
    return bookService.getTestBUR(id);
    }
//1
@GetMapping("/all-read-and-users")
    public List<UserBooksResponse> getAllReadBooks (){
    return bookService.getReadBooks();
}

    //2
    @GetMapping("/books-of-one-user/{id}")
    public List<Book> getReadBooksOfUser (@PathVariable Long id){
    return bookService.getReadBooksOfUser(id);
    }


}