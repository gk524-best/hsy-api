package com.hsy.manager.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT工具类
 * @Author: gk
 * @Date: Created in 2021/2/4 14:29
 */
public class JwtUtil {
    private static JwtUtil instance;

    // 密钥
    public String secret = "SDp7vnj5x7qPP7f2";

    // token 过期时间 1小时
    public long accessTokenExpired = 60 * 60  * 1000;

    // refresh token 过期时间 7天
    public long refreshTokenExpired = 60 * 60 * 24 * 7 * 1000;

    private static JwtBuilder jwtBuilder;

    public static JwtUtil getInstance() {
        if (instance == null) {
            instance = new JwtUtil();
        }
        jwtBuilder = Jwts.builder();
        return instance;
    }

    public String generateToken(Long expired, String secret) {
        return jwtBuilder
                .setSubject("hsy-developer")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expired))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    /**
     * access token
     * @Author gk
     * @Date Created in 2021/2/4 16:00
     * @param expired: 过期时间
     * @param secret: 密钥
     * @Return
     */
    public String generateAccessToken(Long expired, String secret) {
        long ex = expired == null ? this.accessTokenExpired : expired;
        String se = secret == null ? this.secret : secret;
        return this.generateToken(ex, se);
    }
    /**
     * refresh token
     * @Author gk
     * @Date Created in 2021/2/4 16:03
     * @param expired: 过期时间
     * @param secret: 密钥
     * @Return
     */
    public String generateRefreshToken(Long expired, String secret) {
        long ex = expired == null ? this.refreshTokenExpired : expired;
        String se = secret == null ? this.secret : secret;
        return this.generateToken(ex, se);
    }
}
