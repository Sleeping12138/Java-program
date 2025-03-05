package com.test.spring2025_3_5.Mapper;

import com.test.spring2025_3_5.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void deleteUser() {
        userInfoMapper.deleteUser(8);
    }

    @Test
    void updateUser() {
        userInfoMapper.updateUser(7);
    }

    @Test
    void selectUserInfo() {
        userInfoMapper.selectUserInfo(3);
    }

    @Test
    void insertUserInfo() {
        userInfoMapper.insertUserInfo("zhaoliu","123456",18);
    }

    @Test
    void deleteUserInfo() {
        userInfoMapper.deleteUserInfo(10);
    }

    @Test
    void updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wangwu");
        userInfo.setPassword("54321");
        userInfo.setId(6);
        userInfoMapper.updateUserInfo(userInfo);
    }
}