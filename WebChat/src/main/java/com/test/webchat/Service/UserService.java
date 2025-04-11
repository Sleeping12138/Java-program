package com.test.webchat.Service;

import com.test.webchat.Pojo.Model.UserInfo;

public interface UserService {

    UserInfo selectByName(String userName, String password);
}
