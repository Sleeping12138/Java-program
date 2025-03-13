package com.test.librarymanagement.Service;

import com.test.librarymanagement.Mapper.UserInfoMapper;
import com.test.librarymanagement.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo selectUserInfo(String name) {
        return userInfoMapper.selectUserInfo(name);
    }
}
