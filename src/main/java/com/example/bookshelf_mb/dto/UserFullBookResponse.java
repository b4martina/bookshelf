package com.example.bookshelf_mb.dto;

import com.example.bookshelf_mb.model.BookStatus;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id","title","author","status","name","surname"})
public class UserFullBookResponse {

    private Long id;
    private String title;
    private String author;
    private BookStatus status;

    private String name;
    private String surname;

    public UserFullBookResponse(){}

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

   // public int getTimesRead() {
      //  return timesRead;
    //}

    //public void setTimesRead(int timesRead) {
    //    this.timesRead = timesRead;
    //}

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
}
