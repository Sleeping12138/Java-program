package com.test.spring2025_3_20.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.spring2025_3_20.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void selectUserInfoList() {
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.lt("age",20);
        userInfoMapper.selectUserInfoList(userInfoQueryWrapper);
    }
}