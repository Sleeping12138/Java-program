package com.test.lotterysystem;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

//@SpringBootTest
public class EncryptTest {
    @Test
    public void encrypt(){
        /**
         * 使用md5加密算法
         */
        String temp = UUID.randomUUID().toString().replace("-", "");
        String ret = DigestUtils.md5DigestAsHex((temp + "123456").getBytes(StandardCharsets.UTF_8));
        System.out.println(ret);
    }

    /**
     * 使用对称加密算法
     */
    @Test
    public void encrypt2(){
        // 16 24 32
        byte[] key = "123456789abcdfgh".getBytes();
        AES aes = SecureUtil.aes(key);
        String s = aes.encryptHex("123456");
        System.out.println(s);

        String ret = aes.decryptStr(s);
        System.out.println(ret);

    }
}
