package com.test.webchat.Controller;

import com.test.webchat.Pojo.Model.Friend;
import com.test.webchat.Pojo.Model.UserInfo;
import com.test.webchat.Pojo.Response.UserInfoResponse;
import com.test.webchat.Pojo.Response.UserInfoSimple;
import com.test.webchat.Service.UserService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public UserInfoResponse login(@NotBlank(message = "用户名不能为空") String userName, @NotBlank(message = "密码不能为空") String password) {
        log.info("userName:" + userName, "password" + password);
        return userService.selectByName(userName, password);
    }

    @RequestMapping("/register")
    public UserInfoSimple register(@NotBlank(message = "用户名不能为空") String userName, @NotBlank(message = "密码不能为空") String password) {
        return userService.register(userName, password);
    }

    @RequestMapping("/getUserInfo")
    public UserInfoSimple getUserInfo(Integer userId) {
        return userService.getUserInfo(userId);
    }

    @RequestMapping("/getFriendList")
    public List<Friend> getFriendList(Integer userId){
        return userService.getFriendList(userId);
    }
}
