package com.sneivlp.sneivlpidentityservice.service.impl;

import com.sneivlp.sneivlpidentityservice.dto.request.CreateUserRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.UserResponse;
import com.sneivlp.sneivlpidentityservice.entity.User;
import com.sneivlp.sneivlpidentityservice.repository.UserRepository;
import com.sneivlp.sneivlpidentityservice.service.UserService;
import com.sneivlp.sneivlpsecurity.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(CreateUserRequest request) {

        if (userRepository.existsByUsername(request.getUserName())) {
            throw new RuntimeException("Username already exists");
        }

        Role role;

        try {
            role = Role.valueOf(request.getRole().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Invalid role: " + request.getRole());
        }

        User user = new User();
        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        user.setAccountEnabled(true);
        user.setAccountLocked(false);

        userRepository.save(user);

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

    @Override
    public UserResponse getUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole()
                ))
                .toList();
    }
}