package com.test.spring2025_3_3.Mapper;

import com.test.spring2025_3_3.Model.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void getList() {
        System.out.println(userInfoMapper.getList());
    }


    @Test
    void getListByUserName() {
        System.out.println(userInfoMapper.getListByUserName("zhangsan"));
    }

    @BeforeEach
    void setUp() {
        System.out.println("test beginning...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("test ending...");
    }


    @Test
    void getListByNameAndAge() {
        System.out.println(userInfoMapper.getListByNameAndAge("zhangsan", 18));
    }


    @Test
    void addListByNameAndAge2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wangwu");
        userInfo.setPassword("123456");
        userInfo.setAge(18);
        Integer number = userInfoMapper.addListByNameAndAge2(userInfo);
        System.out.println(number);
        System.out.println(userInfo.getId());
    }
}
