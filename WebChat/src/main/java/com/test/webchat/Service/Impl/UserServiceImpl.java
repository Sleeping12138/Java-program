package com.test.webchat.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.webchat.Mapper.UserInfoMapper;
import com.test.webchat.Pojo.Model.UserInfo;
import com.test.webchat.Service.UserService;
import com.test.webchat.Utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectByName(String userName, String password) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUserName,userName);

        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if(userInfo==null|| !SecurityUtil.verify(password,userInfo.getPassword())){
            log.info("用户名或密码错误...");
            return new UserInfo();
        }

        return userInfo;
    }
}
