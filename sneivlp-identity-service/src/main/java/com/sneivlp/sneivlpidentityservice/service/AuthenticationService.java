package com.sneivlp.sneivlpidentityservice.service;

import com.sneivlp.sneivlpidentityservice.dto.request.LoginRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest loginRequest);
}
