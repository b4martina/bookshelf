package com.example.bookshelf_mb.dto;

import java.util.List;

//created to return books of each user
public class UserBooksResponse {
    private String name;
    private String surname;
    private List<String> books;

    public UserBooksResponse(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
