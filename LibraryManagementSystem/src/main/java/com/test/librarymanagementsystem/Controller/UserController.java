package com.test.librarymanagementsystem.Controller;

import com.test.librarymanagementsystem.Constant.Constants;
import com.test.librarymanagementsystem.Model.UserInfo;
import com.test.librarymanagementsystem.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 用户登录接口
    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession httpSession) {
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }

        // 从数据库中查询用户信息
        UserInfo userInfo = userService.selectUserInfo(userName);
        if(userInfo==null) return false;
        if(password.equals(userInfo.getPassword())){
            httpSession.setAttribute(Constants.USER_INFO_SESSION,userInfo);
            return true;
        }
        return false;
    }
}
