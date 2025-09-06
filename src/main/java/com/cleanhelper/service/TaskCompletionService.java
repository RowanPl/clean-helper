package com.cleanhelper.service;

import com.cleanhelper.dto.TaskCompletionDTO;
import com.cleanhelper.model.Task;
import com.cleanhelper.model.TaskCompletion;
import com.cleanhelper.model.User;
import com.cleanhelper.repository.TaskCompletionRepository;
import com.cleanhelper.repository.TaskRepository;
import com.cleanhelper.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskCompletionService {
    private final TaskCompletionRepository completionRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskCompletionService(TaskCompletionRepository completionRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.completionRepository = completionRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskCompletionDTO> findAll() {
        return completionRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TaskCompletionDTO save(TaskCompletionDTO dto) {
        TaskCompletion completion = new TaskCompletion();
        if (dto.getTaskId() != null) {
            Task task = taskRepository.findById(dto.getTaskId()).orElse(null);
            completion.setTask(task);
        }
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            completion.setUser(user);
        }
        completion.setActualCost(dto.getActualCost());
        completion.setCompletedAt(dto.getCompletedAt());
        completion.setExceptional(dto.isExceptional());
        completion = completionRepository.save(completion);
        return toDTO(completion);
    }

    private TaskCompletionDTO toDTO(TaskCompletion completion) {
        TaskCompletionDTO dto = new TaskCompletionDTO();
        dto.setId(completion.getId());
        if (completion.getTask() != null) {
            dto.setTaskId(completion.getTask().getId());
        }
        if (completion.getUser() != null) {
            dto.setUserId(completion.getUser().getId());
        }
        dto.setActualCost(completion.getActualCost());
        dto.setCompletedAt(completion.getCompletedAt());
        dto.setExceptional(completion.isExceptional());
        return dto;
    }
}
