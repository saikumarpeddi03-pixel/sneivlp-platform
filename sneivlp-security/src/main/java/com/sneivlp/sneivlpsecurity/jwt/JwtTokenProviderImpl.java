package com.sneivlp.sneivlpsecurity.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProviderImpl implements JwtTokenProvider {

    @Override
    public String generateToken(String username) {

        Date now = new Date();

        Date expiryDate = new Date(
                now.getTime() +
                        JwtConstants.ACCESS_TOKEN_EXPIRATION
        );

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(JwtUtils.getSigningKey())
                .compact();
    }



    @Override
    public String refreshToken(String refreshToken) {
        return "";
    }

    @Override
    public String usernameFromToken(String token) {

        return getClaims(token)
                .getSubject();
    }

    @Override
    public Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(JwtUtils.getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    @Override
    public boolean validateToken(String token) {

        try {

            getClaims(token);

            return true;

        } catch (SecurityException ex) {

            return false;

        } catch (Exception ex) {

            return false;
        }
    }
}
