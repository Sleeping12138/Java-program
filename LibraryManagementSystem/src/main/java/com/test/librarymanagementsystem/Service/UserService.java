package com.test.librarymanagementsystem.Service;

import com.test.librarymanagementsystem.Mapper.UserMapper;
import com.test.librarymanagementsystem.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public UserInfo selectUserInfo(String userName) {
        return userMapper.selectUserInfo(userName);
    }
}
