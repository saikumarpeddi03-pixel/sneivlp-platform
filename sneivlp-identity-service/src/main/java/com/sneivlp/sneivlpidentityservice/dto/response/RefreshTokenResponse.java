package com.sneivlp.sneivlpidentityservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RefreshTokenResponse {

    private String accessToken;

    private String refreshToken;

    public RefreshTokenResponse(String accessToken, String refreshToken, String tokenType) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
    }

    private String tokenType;

}
