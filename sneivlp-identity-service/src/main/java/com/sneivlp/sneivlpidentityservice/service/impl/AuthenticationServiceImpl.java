package com.sneivlp.sneivlpidentityservice.service.impl;

import com.sneivlp.sneivlpidentityservice.dto.request.LoginRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.LoginResponse;
import com.sneivlp.sneivlpidentityservice.entity.User;
import com.sneivlp.sneivlpidentityservice.repository.UserRepository;
import com.sneivlp.sneivlpidentityservice.service.AuthenticationService;
import com.sneivlp.sneivlpsecurity.jwt.JwtTokenProvider;
import com.sneivlpcommon.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    public LoginResponse  login(LoginRequest loginRequest) {
        User user = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new BusinessException("Invalid UserName or Password"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

                    throw new BusinessException("Invalid UserName or Password");

        }

        String token = jwtTokenProvider
                .generateToken(user.getUsername());

        return new LoginResponse(
                token,
                "Bearer",
                user.getUsername(),
                user.getRole()
        );

    }

}
