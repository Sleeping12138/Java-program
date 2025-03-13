package com.test.librarymanagement.Mapper;

import com.test.librarymanagement.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void selectUserInfo() {
        UserInfo ret = userInfoMapper.selectUserInfo("zhangsan");
        System.out.println(ret);
    }
}