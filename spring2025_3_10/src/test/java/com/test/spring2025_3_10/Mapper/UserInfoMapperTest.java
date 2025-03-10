package com.test.spring2025_3_10.Mapper;

import com.test.spring2025_3_10.Model.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectUserInfo() {
        List<UserInfo> userInfos = userInfoMapper.selectUserInfo();
        System.out.println(userInfos);
    }

    @Test
    void insertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lisi");
        userInfo.setPassword("123456");
//        userInfo.setAge(18);
        userInfo.setPhone("123456");
        userInfoMapper.insertUserInfo(userInfo);
    }

    @Test
    void insertUserInfo2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lisi");
        userInfo.setPassword("123456");
//        userInfo.setAge(18);
        userInfo.setPhone("123456");
        userInfoMapper.insertUserInfo2(userInfo);
    }

    @Test
    void selectUserInfo2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("zhangsan");
//        userInfo.setAge(18);
        userInfoMapper.selectUserInfo2(userInfo);
    }

    @Test
    void updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("zhangsan");
        userInfo.setAge(30);
        userInfo.setPhone("11111");
        userInfoMapper.updateUserInfo(userInfo);
    }

    @Test
    void deleteUserInfo() {
        int[] nums = {12,13,14,15};
        userInfoMapper.deleteUserInfo(nums);
    }
}