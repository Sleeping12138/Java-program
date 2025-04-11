package com.test.webchat;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SecurityTest {
    @Test
    public void encrypt(){
        String salt = UUID.randomUUID().toString().replace("-","");
        String temp = DigestUtils.md5DigestAsHex((salt + "123456").getBytes(StandardCharsets.UTF_8));
        System.out.println(salt+temp);
    }
}
