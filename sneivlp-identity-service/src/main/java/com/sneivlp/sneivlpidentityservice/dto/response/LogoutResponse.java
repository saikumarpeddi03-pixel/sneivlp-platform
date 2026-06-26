package com.sneivlp.sneivlpidentityservice.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LogoutResponse {

    private String message;

    public LogoutResponse(String message) {
        this.message = message;
    }
}
