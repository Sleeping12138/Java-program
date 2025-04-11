package com.test.webchat;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.security.Key;

public class JWTTest {
    @Test
    public void testJWT() {
        // 生成密钥
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // 获取密钥
        String code = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(code);
    }
}
