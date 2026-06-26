package com.sneivlp.sneivlpidentityservice.service;

import com.sneivlp.sneivlpidentityservice.dto.request.LoginRequest;
import com.sneivlp.sneivlpidentityservice.dto.request.RefreshTokenRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.LoginResponse;
import com.sneivlp.sneivlpidentityservice.dto.response.RefreshTokenResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest loginRequest);

    RefreshTokenResponse refreshToken(
            RefreshTokenRequest request);
}
