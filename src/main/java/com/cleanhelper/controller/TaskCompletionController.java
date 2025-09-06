package com.cleanhelper.controller;

import com.cleanhelper.dto.TaskCompletionDTO;
import com.cleanhelper.service.TaskCompletionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-completions")
public class TaskCompletionController {
    private final TaskCompletionService taskCompletionService;

    public TaskCompletionController(TaskCompletionService taskCompletionService) {
        this.taskCompletionService = taskCompletionService;
    }

    @GetMapping
    public List<TaskCompletionDTO> all() {
        return taskCompletionService.findAll();
    }

    @PostMapping
    public TaskCompletionDTO create(@RequestBody TaskCompletionDTO dto) {
        return taskCompletionService.save(dto);
    }
}
