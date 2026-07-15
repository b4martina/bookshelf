package com.example.bookshelf_mb.dto;

import jakarta.validation.constraints.NotBlank;

public class BookRequest {
    @NotBlank(message = "Title cannot be empty") // Validation
    private String title;

    @NotBlank(message = "Author cannot be empty") // Validation
    private String author;


    public BookRequest(){}

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
}
