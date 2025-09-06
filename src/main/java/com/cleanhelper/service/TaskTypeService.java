package com.cleanhelper.service;

import com.cleanhelper.dto.TaskTypeDTO;
import com.cleanhelper.dto.TaskTypeInputDTO;
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

    public TaskTypeDTO findById(Long id) {
        return taskTypeRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public TaskTypeDTO create(TaskTypeInputDTO dto) {
        TaskType type = new TaskType();
        updateEntity(type, dto);
        return toDTO(taskTypeRepository.save(type));
    }

    public TaskTypeDTO update(Long id, TaskTypeInputDTO dto) {
        return taskTypeRepository.findById(id).map(existing -> {
            updateEntity(existing, dto);
            return toDTO(taskTypeRepository.save(existing));
        }).orElse(null);
    }

    public void delete(Long id) {
        taskTypeRepository.deleteById(id);
    }

    private void updateEntity(TaskType type, TaskTypeInputDTO dto) {
        type.setName(dto.getName());
    }

    private TaskTypeDTO toDTO(TaskType type) {
        TaskTypeDTO dto = new TaskTypeDTO();
        dto.setId(type.getId());
        dto.setName(type.getName());
        return dto;
    }
}