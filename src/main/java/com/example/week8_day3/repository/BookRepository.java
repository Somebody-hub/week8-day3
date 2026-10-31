package com.example.week8_day3.repository;


import com.example.week8_day3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByPublicationYear(Integer publicationYear);

    List<Book> findByTitleContainingIgnoreCase(java.lang.String title);

}
