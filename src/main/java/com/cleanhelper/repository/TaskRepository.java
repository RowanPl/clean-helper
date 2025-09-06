package com.cleanhelper.repository;

import com.cleanhelper.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

}
