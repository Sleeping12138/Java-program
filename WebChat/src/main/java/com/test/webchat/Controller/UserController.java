package com.test.webchat.Controller;

import com.test.webchat.Pojo.Model.UserInfo;
import com.test.webchat.Service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public UserInfo login(@NotNull(message = "用户名不能为空") String userName,@NotNull(message = "密码不能为空") String password){
        return userService.selectByName(userName,password);
    }
}
