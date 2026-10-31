package com.example.week8_day3.repository;

import com.example.week8_day3.model.Student;
import com.example.week8_day3.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByGroupName(StudentGroup studentGroup);

    Optional<Student> findByGradeBook(String gradeBook);
}
