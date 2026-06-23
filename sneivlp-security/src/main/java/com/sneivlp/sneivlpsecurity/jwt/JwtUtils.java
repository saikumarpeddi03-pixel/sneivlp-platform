package com.sneivlp.sneivlpsecurity.jwt;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public final class JwtUtils {

    private JwtUtils() {
    }

    private static final String SECRET_KEY =
            "SNEIVLP_SUPER_SECURE_JWT_SECRET_KEY_2026_VERY_LONG_KEY";

    public static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8)
        );
    }
}
