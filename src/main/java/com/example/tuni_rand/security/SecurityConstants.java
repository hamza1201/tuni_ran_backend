package com.example.tuni_rand.security;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/api/users/**";
    public static final String H2_URL = "h2-console/**";
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "bearer ";
    public static final String HEADER_STRING ="Authorization";
    public static final long EXPIRATION_TIME = 5 * 60 * 60; // 10 day
}
