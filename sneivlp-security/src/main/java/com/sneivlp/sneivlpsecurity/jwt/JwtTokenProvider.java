package com.sneivlp.sneivlpsecurity.jwt;

import io.jsonwebtoken.Claims;


public interface JwtTokenProvider {

    String generateToken(String username);

    String usernameFromToken(String token);

    String refreshToken(String refreshToken);

    boolean validateToken(String token);

    Claims getClaims(String token);
}
