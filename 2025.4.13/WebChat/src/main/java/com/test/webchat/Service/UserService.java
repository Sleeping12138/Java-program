package com.test.webchat.Service;

import com.test.webchat.Pojo.Model.Friend;
import com.test.webchat.Pojo.Model.UserInfo;
import com.test.webchat.Pojo.Response.UserInfoResponse;
import com.test.webchat.Pojo.Response.UserInfoSimple;

import java.util.List;

public interface UserService {

    UserInfoResponse selectByName(String userName, String password);

    UserInfoSimple register(String userName, String password);

    UserInfoSimple getUserInfo(Integer userId);

    List<Friend> getFriendList(Integer userId);
}
