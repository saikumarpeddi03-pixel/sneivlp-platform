package com.sneivlp.sneivlpidentityservice.service;

import com.sneivlp.sneivlpidentityservice.dto.request.CreateUserRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    UserResponse getUser(Long id);

    List<UserResponse> getAllUsers();
}
