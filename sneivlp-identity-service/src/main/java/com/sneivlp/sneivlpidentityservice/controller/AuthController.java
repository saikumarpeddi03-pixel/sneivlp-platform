package com.sneivlp.sneivlpidentityservice.controller;

import com.sneivlp.sneivlpidentityservice.dto.request.LoginRequest;
import com.sneivlp.sneivlpidentityservice.dto.request.LogoutRequest;
import com.sneivlp.sneivlpidentityservice.dto.request.RefreshTokenRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.LoginResponse;
import com.sneivlp.sneivlpidentityservice.dto.response.LogoutResponse;
import com.sneivlp.sneivlpidentityservice.dto.response.RefreshTokenResponse;
import com.sneivlp.sneivlpidentityservice.service.AuthenticationService;
import com.sneivlpcommon.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/refresh")
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        
        return authenticationService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse> logout(@RequestHeader("Authorization") String authorization, LogoutRequest logoutRequest){

        String accessToken = authorization.replace("Bearer ", "");

        LogoutResponse response =  authenticationService.logout(accessToken, logoutRequest);

        ApiResponse<LogoutResponse> apiResponse = new ApiResponse();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Logout successful");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse);
    }

}
