package com.test.spring2025_3_20.UserInfoMapperTest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.test.spring2025_3_20.Mapper.UserInfoMapper;
import com.test.spring2025_3_20.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void insertUser(){
        UserInfo user = new UserInfo();
        user.setUsername("zjy");
        user.setPassword("123456");
        user.setAge(11);
        user.setGender(0);
        user.setPhone("18610001234");
        userInfoMapper.insert(user);
    }

    @Test
    public void deleteUserInfoById(){
        int index = userInfoMapper.deleteById(5);
        System.out.println(index);
    }

    @Test
    public void updateUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(4);
        userInfo.setAge(30);
        userInfoMapper.updateById(userInfo);
    }

    @Test
    public void selectUserInfoById(){
        UserInfo userInfo = userInfoMapper.selectById(1);
        System.out.println(userInfo);
    }

    @Test
    public void selectUserInfo(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","username","password","age")
                .eq("age",18).like("username","min");
        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        System.out.println(userInfos);
    }

    @Test
    public void selectUserInfo2(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(UserInfo::getUserId).select(UserInfo::getUsername).select(UserInfo::getPassword)
                .select(UserInfo::getAge).eq(UserInfo::getAge,18).like(UserInfo::getUsername,"min");
        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        System.out.println(userInfos);
    }

    @Test
    public void updateUserInfo2(){
        UpdateWrapper<UserInfo> userInfoUpdateWrapper = new UpdateWrapper<>();
        userInfoUpdateWrapper.set("delete_flag",1).lt("age",20);
        userInfoMapper.update(userInfoUpdateWrapper);
    }

    @Test
    public void updateUserInfo3(){
        UpdateWrapper<UserInfo> userInfoUpdateWrapper = new UpdateWrapper<>();
        userInfoUpdateWrapper.lambda().set(UserInfo::getDeleteFlag,0).lt(UserInfo::getAge,20);
        userInfoMapper.update(userInfoUpdateWrapper);
    }

    @Test
    public void deleteUserInfo(){
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.lambda().eq(UserInfo::getUserId,3);
        userInfoMapper.delete(userInfoQueryWrapper);
    }
}
