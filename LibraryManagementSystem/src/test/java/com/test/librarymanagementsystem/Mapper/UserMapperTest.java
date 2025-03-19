package com.test.librarymanagementsystem.Mapper;

import com.test.librarymanagementsystem.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectUserInfo() {
        UserInfo userInfo = userMapper.selectUserInfo("admin");
        System.out.println(userInfo.toString());
    }
}