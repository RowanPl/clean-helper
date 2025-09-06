package com.cleanhelper.service;

import com.cleanhelper.dto.UserDTO;
import com.cleanhelper.model.User;
import com.cleanhelper.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public UserDTO save(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setWeeklyEnergyCap(dto.getWeeklyEnergyCap());
        user = userRepository.save(user);
        return toDTO(user);
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setWeeklyEnergyCap(user.getWeeklyEnergyCap());
        return dto;
    }
}
