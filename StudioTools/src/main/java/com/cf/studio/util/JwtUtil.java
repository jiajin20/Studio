package com.cf.studio.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
public class JwtUtil {
    private static final String SECRET_KEY = "your_secret_key";

    // 生成 Token
    public static String createToken(int userid) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.create()
                .withClaim("userid", String.valueOf(userid)) // 存储为字符串
                .withIssuer("auth0")
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 小时过期
                .sign(algorithm);
    }

    // 验证 Token
    public static DecodedJWT verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }
}

