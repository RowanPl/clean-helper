package com.cleanhelper.controller;

import com.cleanhelper.dto.UserDTO;

import com.cleanhelper.dto.UserInputDTO;

import com.cleanhelper.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> all() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping

    public UserDTO create(@RequestBody UserInputDTO dto) {
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserInputDTO dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
