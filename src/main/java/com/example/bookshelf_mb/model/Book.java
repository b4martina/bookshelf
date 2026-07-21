package com.example.bookshelf_mb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="BOOKS")

public class Book {
@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="ID")
    private Long id;

    @Column(name="TITLE")
    private  String title;

    @Column(name="AUTHOR")
    private String author;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(name="READ_COUNT")
    private Integer readCount;

    @Column(name = "CREATED_AT", nullable = false, updatable = false) //user can not modify creation time
    private LocalDate createdAt;


    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    @JsonIgnore
    private User owner;
   /* @Column(name="OWNER_ID")
    private Long ownerId;
*/
    public Book(){}

    public Book(Long id, String title, String author, BookStatus status, Integer readCount, User owner) //changed user owner from long owner_id
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.readCount = readCount;
this.owner=owner;    }

}
