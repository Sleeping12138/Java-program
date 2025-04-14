package com.test.webchat.Utils;


import com.test.webchat.Constants.Constant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;

public class JWTUtil {
    private static final String SECRET_StRING = Constant.JWT_KEY;
    private static Key key = Keys.hmacShaKeyFor(SECRET_StRING.getBytes(StandardCharsets.UTF_8));

    // 获取token
    public static String getKey(Map<String,Object> claims) {
        String compact = Jwts.builder().setClaims(claims).signWith(key).compact();
        return compact;
    }

    // 校验token
    public static Claims parseToken(String token) {
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        return build.parseClaimsJws(token).getBody();
    }
}
