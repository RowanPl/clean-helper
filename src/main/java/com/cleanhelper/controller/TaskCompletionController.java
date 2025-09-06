package com.cleanhelper.controller;

import com.cleanhelper.dto.TaskCompletionDTO;



import com.cleanhelper.dto.TaskCompletionInputDTO;
import com.cleanhelper.service.TaskCompletionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-completions")
public class TaskCompletionController {



    private final TaskCompletionService completionService;

    public TaskCompletionController(TaskCompletionService completionService) {
        this.completionService = completionService;
}



    @GetMapping
    public List<TaskCompletionDTO> all() {

        return completionService.findAll();
    }

    @GetMapping("/{id}")
    public TaskCompletionDTO get(@PathVariable Long id) {
        return completionService.findById(id);
    }

    @PostMapping
    public TaskCompletionDTO create(@RequestBody TaskCompletionInputDTO dto) {
        return completionService.create(dto);
    }

    @PutMapping("/{id}")
    public TaskCompletionDTO update(@PathVariable Long id, @RequestBody TaskCompletionInputDTO dto) {
        return completionService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        completionService.delete(id);
    }

}
