package com.cleanhelper.service;

import com.cleanhelper.dto.EnergyProfileDTO;
import com.cleanhelper.dto.EnergyProfileInputDTO;
import com.cleanhelper.model.EnergyProfile;
import com.cleanhelper.model.TaskType;
import com.cleanhelper.model.User;
import com.cleanhelper.repository.EnergyProfileRepository;
import com.cleanhelper.repository.TaskTypeRepository;

import com.cleanhelper.dto.TaskCompletionDTO;
import com.cleanhelper.dto.TaskCompletionInputDTO;
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
public class EnergyProfileService {
    private final EnergyProfileRepository energyProfileRepository;
    private final UserRepository userRepository;
    private final TaskTypeRepository taskTypeRepository;

    public EnergyProfileService(EnergyProfileRepository energyProfileRepository, UserRepository userRepository, TaskTypeRepository taskTypeRepository) {
        this.energyProfileRepository = energyProfileRepository;
        this.userRepository = userRepository;
        this.taskTypeRepository = taskTypeRepository;
    }

    public List<EnergyProfileDTO> findAll() {
        return energyProfileRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public EnergyProfileDTO findById(Long id) {
        return energyProfileRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public EnergyProfileDTO create(EnergyProfileInputDTO dto) {
        EnergyProfile profile = new EnergyProfile();
        updateEntity(profile, dto);
        return toDTO(energyProfileRepository.save(profile));
    }

    public EnergyProfileDTO update(Long id, EnergyProfileInputDTO dto) {
        return energyProfileRepository.findById(id).map(existing -> {
            updateEntity(existing, dto);
            return toDTO(energyProfileRepository.save(existing));

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

    public TaskCompletionDTO findById(Long id) {
        return completionRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public TaskCompletionDTO create(TaskCompletionInputDTO dto) {
        TaskCompletion completion = new TaskCompletion();
        updateEntity(completion, dto);
        return toDTO(completionRepository.save(completion));
    }

    public TaskCompletionDTO update(Long id, TaskCompletionInputDTO dto) {
        return completionRepository.findById(id).map(existing -> {
            updateEntity(existing, dto);
            return toDTO(completionRepository.save(existing));
        }).orElse(null);
    }

    public void delete(Long id) {
        energyProfileRepository.deleteById(id);
    }

    private void updateEntity(EnergyProfile profile, EnergyProfileInputDTO dto) {
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            profile.setUser(user);
        } else {
            profile.setUser(null);
        }
        if (dto.getTaskTypeId() != null) {
            TaskType type = taskTypeRepository.findById(dto.getTaskTypeId()).orElse(null);
            profile.setTaskType(type);
        } else {
            profile.setTaskType(null);
        }
        profile.setPredictedCost(dto.getPredictedCost());
        profile.setHistoryWindow(dto.getHistoryWindow());
    }

    private EnergyProfileDTO toDTO(EnergyProfile profile) {
        EnergyProfileDTO dto = new EnergyProfileDTO();
        dto.setId(profile.getId());
        if (profile.getUser() != null) {
            dto.setUserId(profile.getUser().getId());
        }
        if (profile.getTaskType() != null) {
            dto.setTaskTypeId(profile.getTaskType().getId());
        }
        dto.setPredictedCost(profile.getPredictedCost());
        dto.setHistoryWindow(profile.getHistoryWindow());
        return dto;
    }
}
        completionRepository.deleteById(id);
    }

    private void updateEntity(TaskCompletion completion, TaskCompletionInputDTO dto) {
        if (dto.getTaskId() != null) {
            Task task = taskRepository.findById(dto.getTaskId()).orElse(null);
            completion.setTask(task);
        } else {
            completion.setTask(null);
        }
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            completion.setUser(user);
        } else {
            completion.setUser(null);
        }
        completion.setActualCost(dto.getActualCost());
        completion.setCompletedAt(dto.getCompletedAt());
        completion.setExceptional(dto.isExceptional());
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

