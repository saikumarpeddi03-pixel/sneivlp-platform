package com.sneivlp.sneivlpidentityservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class CreateUserRequest {

    @NotBlank
    private  String userName;

    @NotBlank
    private  String password;

    @NotBlank
    private  String role;

    @NotBlank
    private String email;
}
