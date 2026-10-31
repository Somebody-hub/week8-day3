package com.example.week8_day3.repository;

import com.example.week8_day3.model.Task;
import com.example.week8_day3.model.TaskPriority;
import com.example.week8_day3.model.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus taskStatus);

    List<Task> findByStatusAndPriority(TaskStatus taskStatus, TaskPriority taskPriority);

    @Query("select t from Task t where lower(t.title) like lower(concat('%', :text, '%') ) ")
    Page<Task> searchByTitle(@Param("text") String text, Pageable pageable);

}
