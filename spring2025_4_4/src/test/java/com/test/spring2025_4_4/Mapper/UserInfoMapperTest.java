package com.test.spring2025_4_4.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.spring2025_4_4.Model.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserInfoMapperTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Autowired
    private UserInfoMapper userInfoMapper;

//    @Test
//    void getList() {
//        List<UserInfo> list = userInfoMapper.getList();
//        System.out.println("用户名单："+list);
//    }
//
//    @Test
//    void getUserInfoById() {
//        userInfoMapper.getUserInfoById(2);
//    }

    @Test
    void getUserInfo() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",1);
        UserInfo userInfo = userInfoMapper.getUserInfo(queryWrapper);
        System.out.println(userInfo);
    }
}