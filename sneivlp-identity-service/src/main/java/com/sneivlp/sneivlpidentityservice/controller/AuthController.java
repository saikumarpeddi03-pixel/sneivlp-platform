package com.sneivlp.sneivlpidentityservice.controller;

import com.sneivlp.sneivlpidentityservice.dto.request.LoginRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.LoginResponse;
import com.sneivlp.sneivlpidentityservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }
}
