package com.example.week8_day3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;

    @Column(nullable = false)
    private Integer circulation;

    protected Book() {
    }

    public Book(String title, String author, Integer publicationYear, Integer circulation) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.circulation = circulation;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public Integer getCirculation() {
        return circulation;
    }
}
