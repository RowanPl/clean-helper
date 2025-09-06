package com.cleanhelper.service;

import com.cleanhelper.dto.TaskDTO;
import com.cleanhelper.dto.TaskInputDTO;
import com.cleanhelper.model.Task;
import com.cleanhelper.model.TaskStatus;
import com.cleanhelper.model.TaskType;
import com.cleanhelper.model.User;
import com.cleanhelper.repository.TaskRepository;
import com.cleanhelper.repository.TaskTypeRepository;
import com.cleanhelper.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskTypeRepository taskTypeRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, TaskTypeRepository taskTypeRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskTypeRepository = taskTypeRepository;
    }

    public List<TaskDTO> findAll() {
        return taskRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TaskDTO findById(Long id) {
        return taskRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public TaskDTO create(TaskInputDTO dto) {
        Task task = new Task();
        updateEntity(task, dto);
        return toDTO(taskRepository.save(task));
    }

    public TaskDTO update(Long id, TaskInputDTO dto) {
        return taskRepository.findById(id).map(existing -> {
            updateEntity(existing, dto);
            return toDTO(taskRepository.save(existing));
        }).orElse(null);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    private void updateEntity(Task task, TaskInputDTO dto) {
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStartTime(dto.getStartTime());
        task.setEndTime(dto.getEndTime());
        if (dto.getStatus() != null) {
            task.setStatus(TaskStatus.valueOf(dto.getStatus()));
        }
        if (dto.getTaskTypeId() != null) {
            TaskType type = taskTypeRepository.findById(dto.getTaskTypeId()).orElse(null);
            task.setTaskType(type);
        } else {
            task.setTaskType(null);
        }
        if (dto.getAssigneeIds() != null) {
            Set<User> assignees = new HashSet<>(userRepository.findAllById(dto.getAssigneeIds()));
            task.setAssignees(assignees);
        } else {
            task.setAssignees(new HashSet<>());
        }
    }

    private TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStartTime(task.getStartTime());
        dto.setEndTime(task.getEndTime());
        if (task.getStatus() != null) {
            dto.setStatus(task.getStatus().name());
        }
        if (task.getTaskType() != null) {
            dto.setTaskTypeId(task.getTaskType().getId());
        }
        if (task.getAssignees() != null) {
            dto.setAssigneeIds(task.getAssignees().stream().map(User::getId).collect(Collectors.toSet()));
        }
        return dto;
    }
}