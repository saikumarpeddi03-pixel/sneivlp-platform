package com.sneivlp.sneivlpsecurity.jwt;

public final class JwtConstants {

    private JwtConstants() {}

    public static final String HEADER_STRING = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final long ACCESS_TOKEN_EXPIRATION =
            1000L * 60 * 15;

    public static final long REFRESH_TOKEN_EXPIRATION =
            1000L * 60 * 60 * 24 * 7;

    public static final String SECRET = "YourSuperSecretKeyForSneivlpPlatform123456789";
}