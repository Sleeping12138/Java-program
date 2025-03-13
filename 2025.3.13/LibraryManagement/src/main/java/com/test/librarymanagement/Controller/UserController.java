package com.test.librarymanagement.Controller;

import com.test.librarymanagement.Model.UserInfo;
import com.test.librarymanagement.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public boolean userName(String name, String password) {
        if(!StringUtils.hasLength(name)||!StringUtils.hasLength(password)) return false;
        UserInfo userInfo = userInfoService.selectUserInfo(name);
        if(userInfo==null){
            return false;
        }
        if(password.equals(userInfo.getPassword())) {
            return true;
        }
        return false;
    }
}
