package com.example.week8_day3.config;

import com.example.week8_day3.model.*;
import com.example.week8_day3.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;

@Configuration
public class SqlDemoRunner {

    @Bean
    CommandLineRunner demo(BookRepository books,
                           ProductRepository products,
                           StudentRepository students,
                           TaskRepository tasks) {
        return args -> {
            // --- данные ---
            books.save(new Book("Война и мир", "Толстой", 1869, 100));
            books.save(new Book("Анна Каренина", "Толстой", 1877, 200));
            products.save(new Product("Хлеб", "food", new BigDecimal("1.50")));
            products.save(new Product("Сыр", "food", new BigDecimal("12.90")));
            students.save(new Student("Иван Иванов", StudentGroup.IT_303, "ZK-001"));
            tasks.save(new Task("Написать отчёт", "по неделе 8", TaskPriority.HIGH));

            // --- Book ---
            System.out.println("=== BOOK: findByAuthor");
            books.findByAuthor("Толстой");
            System.out.println("=== BOOK: findByYear");
            books.findByPublicationYear(1869);
            System.out.println("=== BOOK: findByTitleContainingIgnoreCase");
            books.findByTitleContainingIgnoreCase("война");

            // --- Product ---
            System.out.println("=== PRODUCT: findByPriceGreaterThan");
            products.findByPriceGreaterThan(new BigDecimal("5"));
            System.out.println("=== PRODUCT: findByCategory + Sort");
            products.findByCategory("food", Sort.by("price").descending());
            System.out.println("=== PRODUCT: count / countByCategory");
            products.count();
            products.countByCategory("food");

            // --- Student ---
            System.out.println("=== STUDENT: findByGroupName");
            students.findByGroupName(StudentGroup.IT_303);
            System.out.println("=== STUDENT: findByRecordBookNumber");
            students.findByGradeBook("ZK-001");

            // --- Task ---
            System.out.println("=== TASK: findByStatus");
            tasks.findByStatus(TaskStatus.NEW);
            System.out.println("=== TASK: findByStatusAndPriority");
            tasks.findByStatusAndPriority(TaskStatus.NEW, TaskPriority.HIGH);
            System.out.println("=== TASK: searchByTitle (Page: select + count)");
            tasks.searchByTitle("отчёт", PageRequest.of(0, 5, Sort.by("createdAt")));

            System.out.println("=== BOOK: findByAuthor");
            System.out.println(books.findByAuthor("Толстой").stream()
                    .map(Book::getTitle).toList());

            System.out.println("=== PRODUCT: count / countByCategory");
            System.out.println("всего: " + products.count());
            System.out.println("в категории food: " + products.countByCategory("food"));

            System.out.println("=== STUDENT: findByRecordBookNumber");
            System.out.println(students.findByGradeBook("ZK-001")
                    .map(Student::getFullName).orElse("не найден"));

            System.out.println("=== TASK: searchByTitle (Page)");
            Page<Task> page = tasks.searchByTitle("отчёт", PageRequest.of(0, 5, Sort.by("createdAt")));
            System.out.println("найдено: " + page.getTotalElements()
                    + ", страниц: " + page.getTotalPages()
                    + ", на этой странице: " + page.getContent().stream().map(Task::getTitle).toList());
        };

    }
}