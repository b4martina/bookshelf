package com.example.bookshelf_mb.controllers;


import com.example.bookshelf_mb.model.Book;
import com.example.bookshelf_mb.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){this.bookService=bookService;}

    @PostMapping
    public Book createBook(@RequestBody Book book){return bookService.createBook(book);}

    @GetMapping
    public List<Book> getAllBooks(){return bookService.getAllBooks();}

    @GetMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }
@DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
}
@PutMapping("/{id}/read")
    public  Book markAsRead(@PathVariable Long id) {
    return bookService.markAsRead(id);
}

@PutMapping("/{id}/remove")
    public Book removeBook(@PathVariable Long id){
        return bookService.removeBook(id);
}


}
