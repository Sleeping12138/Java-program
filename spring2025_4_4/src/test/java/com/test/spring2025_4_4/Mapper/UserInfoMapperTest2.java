package com.test.spring2025_4_4.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.spring2025_4_4.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserInfoMapperTest2 {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void selectById2(){
        UserInfo userInfo = userInfoMapper.selectById(1);
        System.out.println(userInfo);
    }

    @Test
    void selectById3(){
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.select("id","username","password","age").eq("id",1);
        List<UserInfo> userInfos = userInfoMapper.selectList(userInfoQueryWrapper);
        System.out.println(userInfos);
    }
}
