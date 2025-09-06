package com.cleanhelper.controller;

import com.cleanhelper.dto.TaskTypeDTO;
import com.cleanhelper.service.TaskTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-types")
public class TaskTypeController {
    private final TaskTypeService taskTypeService;

    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @GetMapping
    public List<TaskTypeDTO> all() {
        return taskTypeService.findAll();
    }

    @PostMapping
    public TaskTypeDTO create(@RequestBody TaskTypeDTO dto) {
        return taskTypeService.save(dto);
    }
}
