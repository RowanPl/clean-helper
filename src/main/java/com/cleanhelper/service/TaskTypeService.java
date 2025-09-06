package com.cleanhelper.service;

import com.cleanhelper.dto.TaskTypeDTO;
import com.cleanhelper.model.TaskType;
import com.cleanhelper.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskTypeService {
    private final TaskTypeRepository taskTypeRepository;

    public TaskTypeService(TaskTypeRepository taskTypeRepository) {
        this.taskTypeRepository = taskTypeRepository;
    }

    public List<TaskTypeDTO> findAll() {
        return taskTypeRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TaskTypeDTO save(TaskTypeDTO dto) {
        TaskType type = new TaskType();
        type.setName(dto.getName());
        type = taskTypeRepository.save(type);
        return toDTO(type);
    }

    private TaskTypeDTO toDTO(TaskType type) {
        TaskTypeDTO dto = new TaskTypeDTO();
        dto.setId(type.getId());
        dto.setName(type.getName());
        return dto;
    }
}
