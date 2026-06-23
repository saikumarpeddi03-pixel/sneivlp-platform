package com.sneivlp.sneivlpsecurity.jwt;

public class JwtConstants {

    private JwtConstants() {}

    public static final String TOKEN_PREFIX = "BEARER";

    public static final String HEADER_STRING = "Authorization";

    public  static final long ACCESS_TOKEN_EXPIRATION  =  1000L * 60 * 60 * 24;

}
