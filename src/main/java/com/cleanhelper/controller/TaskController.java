package com.cleanhelper.controller;

import com.cleanhelper.dto.TaskDTO;

import com.cleanhelper.dto.TaskInputDTO;

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

    @GetMapping("/{id}")
    public TaskDTO get(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskInputDTO dto) {
        return taskService.create(dto);
    }

    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable Long id, @RequestBody TaskInputDTO dto) {
        return taskService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);

}
