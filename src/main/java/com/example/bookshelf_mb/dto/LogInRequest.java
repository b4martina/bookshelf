package com.example.bookshelf_mb.dto;

public class LogInRequest {
 private String name;
private String surname;
 private String password;

 public LogInRequest(){}

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



    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
