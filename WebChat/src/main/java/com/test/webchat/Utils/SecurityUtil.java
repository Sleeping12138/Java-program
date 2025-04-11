package com.test.webchat.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Slf4j
public class SecurityUtil {

    // 加密
    public static String encrypt(String password){
        String salt = UUID.randomUUID().toString().replace("-","");
        String temp = DigestUtils.md5DigestAsHex((salt + password).getBytes(StandardCharsets.UTF_8));
        return salt+temp;
    }

    public static boolean verify(String password,String sqlPassword){
        String salt = sqlPassword.substring(0,32);
        log.info("salt: "+salt);
        String temp = DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        log.info("temp: "+temp);
        return sqlPassword.equals(salt+temp);
    }
}
