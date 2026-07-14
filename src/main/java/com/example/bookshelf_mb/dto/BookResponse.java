package com.example.bookshelf_mb.dto;

import com.example.bookshelf_mb.model.BookStatus;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private BookStatus status;
    private int timesRead;

    public BookResponse(){}

    public BookResponse(Long id, String title, String author, BookStatus status, int timesRead) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.timesRead = timesRead;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public int getTimesRead() {
        return timesRead;
    }

    public void setTimesRead(int timesRead) {
        this.timesRead = timesRead;
    }
}
