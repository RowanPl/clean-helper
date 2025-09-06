package com.cleanhelper.service;

import com.cleanhelper.dto.UserDTO;
import com.cleanhelper.dto.UserInputDTO;
import com.cleanhelper.model.User;
import com.cleanhelper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public UserDTO create(UserInputDTO input) {
        User user = new User();
        updateEntity(user, input);
        return toDTO(userRepository.save(user));
    }

    public UserDTO update(Long id, UserInputDTO input) {
        return userRepository.findById(id).map(existing -> {
            updateEntity(existing, input);
            return toDTO(userRepository.save(existing));
        }).orElse(null);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void updateEntity(User user, UserInputDTO input) {
        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setWeeklyEnergyCap(input.getWeeklyEnergyCap());
        if (input.getPassword() != null) {
            user.setPasswordHash(passwordEncoder.encode(input.getPassword()));
        }
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

}

