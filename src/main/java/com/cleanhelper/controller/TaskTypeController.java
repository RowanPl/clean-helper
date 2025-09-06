package com.cleanhelper.controller;

import com.cleanhelper.dto.TaskTypeDTO;
import com.cleanhelper.dto.TaskTypeInputDTO;
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

    @GetMapping("/{id}")
    public TaskTypeDTO get(@PathVariable Long id) {
        return taskTypeService.findById(id);
    }

    @PostMapping
    public TaskTypeDTO create(@RequestBody TaskTypeInputDTO dto) {
        return taskTypeService.create(dto);
    }

    @PutMapping("/{id}")
    public TaskTypeDTO update(@PathVariable Long id, @RequestBody TaskTypeInputDTO dto) {
        return taskTypeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskTypeService.delete(id);
    }
}
