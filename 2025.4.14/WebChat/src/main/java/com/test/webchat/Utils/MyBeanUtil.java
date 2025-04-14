package com.test.webchat.Utils;

import com.test.webchat.Pojo.Model.Friend;
import com.test.webchat.Pojo.Model.UserInfo;
import com.test.webchat.Pojo.Response.UserInfoResponse;
import com.test.webchat.Pojo.Response.UserInfoSimple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class MyBeanUtil {
    public static UserInfoResponse transToUserInfoResponse(UserInfo userInfo) {
        if(userInfo==null){
            log.info("转换对象为空!");
            return new UserInfoResponse();
        }

        UserInfoResponse userInfoResponse = new UserInfoResponse();
        BeanUtils.copyProperties(userInfo,userInfoResponse);
        return userInfoResponse;
    }

    public static UserInfoSimple transToUserInfoSimple(UserInfo userInfo) {
        if(userInfo==null){
            log.info("转换对象为空!");
            return new UserInfoSimple();
        }
        UserInfoSimple userInfoSimple = new UserInfoSimple();
        BeanUtils.copyProperties(userInfo,userInfoSimple);
        return userInfoSimple;
    }

    public static Friend transToFriend(UserInfo userInfo){
        if(userInfo==null){
            log.info("转换对象为空!");
            return new Friend();
        }
        Friend friend = new Friend();
        friend.setFriendId(userInfo.getUserId());
        friend.setFriendName(userInfo.getUserName());
        return friend;
    }
}
