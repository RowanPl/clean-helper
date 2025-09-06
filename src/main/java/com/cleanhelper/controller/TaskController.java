package com.cleanhelper.controller;

import com.cleanhelper.dto.TaskDTO;
import com.cleanhelper.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> all() {
        return taskService.findAll();
    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO dto) {
        return taskService.save(dto);
    }
}
