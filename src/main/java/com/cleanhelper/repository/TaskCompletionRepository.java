package com.cleanhelper.repository;

import com.cleanhelper.model.TaskCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCompletionRepository extends JpaRepository<TaskCompletion, Long> {
}
