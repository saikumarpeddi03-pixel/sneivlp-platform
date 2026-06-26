package com.sneivlp.sneivlpidentityservice.controller;

import com.sneivlp.sneivlpidentityservice.dto.request.CreateUserRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.UserResponse;
import com.sneivlp.sneivlpidentityservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {

        return userService.createUser(request);
    }

    @GetMapping("/id")
    public UserResponse getUser(@RequestParam Long userId) {

        return userService.getUser(userId);
    }

    @GetMapping()
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}
