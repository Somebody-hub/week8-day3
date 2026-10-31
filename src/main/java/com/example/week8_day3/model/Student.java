package com.example.week8_day3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "full_name", length = 100)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "group_name", length = 100)
    private StudentGroup groupName;

    @Column(nullable = false, name = "grade_book", length = 50)
    private String gradeBook;

    protected Student() {
    }

    public Student(String fullName, StudentGroup groupName, String gradeBook) {
        this.fullName = fullName;
        this.groupName = groupName;
        this.gradeBook = gradeBook;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public StudentGroup getGroupName() {
        return groupName;
    }

    public String getGradeBook() {
        return gradeBook;
    }
}
