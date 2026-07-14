package com.example.bookshelf_mb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="PASSWORD")
    private String password;

    public User(){}

    public User(Long id, String name, String surname, String password){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.password=password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
