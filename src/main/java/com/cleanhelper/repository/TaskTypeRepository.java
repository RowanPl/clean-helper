package com.cleanhelper.repository;

import com.cleanhelper.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
}
