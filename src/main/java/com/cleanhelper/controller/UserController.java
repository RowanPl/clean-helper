package com.cleanhelper.controller;

import com.cleanhelper.dto.UserDTO;
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
    public UserDTO create(@RequestBody UserDTO dto) {
        return userService.save(dto);
    }
}
