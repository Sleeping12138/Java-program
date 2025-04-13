package com.test.webchat.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.webchat.Mapper.FriendOfUserMapper;
import com.test.webchat.Mapper.UserInfoMapper;
import com.test.webchat.Pojo.Model.Friend;
import com.test.webchat.Pojo.Model.FriendOfUser;
import com.test.webchat.Pojo.Model.UserInfo;
import com.test.webchat.Pojo.Response.UserInfoResponse;
import com.test.webchat.Pojo.Response.UserInfoSimple;
import com.test.webchat.Service.UserService;
import com.test.webchat.Utils.JWTUtil;
import com.test.webchat.Utils.MyBeanUtil;
import com.test.webchat.Utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private FriendOfUserMapper friendOfUserMapper;

    @Override
    public UserInfoResponse selectByName(String userName, String password) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUserName, userName);

        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if (userInfo == null || !SecurityUtil.verify(password, userInfo.getPassword())) {
            log.info("用户名或密码错误...");
            return new UserInfoResponse();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", userInfo.getUserId());
        map.put("name", userInfo.getUserName());
        String key = JWTUtil.getKey(map);

        UserInfoResponse userInfoResponse = MyBeanUtil.transToUserInfoResponse(userInfo);
        userInfoResponse.setToken(key);
        return userInfoResponse;
    }

    @Override
    public UserInfoSimple register(String userName, String password) {
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userName);
            userInfo.setPassword(SecurityUtil.encrypt(password));
            int ret = userInfoMapper.insert(userInfo);
            if (ret == 1) {
                log.info("新用户为：{}", userInfo);
                return MyBeanUtil.transToUserInfoSimple(userInfo);
            }
            return new UserInfoSimple();
        } catch (DuplicateKeyException e) {
            log.info("注册失败...");
            return new UserInfoSimple();
        }
    }

    @Override
    public UserInfoSimple getUserInfo(Integer userId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUserId,userId);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        return MyBeanUtil.transToUserInfoSimple(userInfo);
    }

    @Override
    public List<Friend> getFriendList(Integer userId) {
        List<Friend> resultList = new ArrayList<>();

        QueryWrapper<FriendOfUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(FriendOfUser::getUserId,userId);
        List<FriendOfUser> friendOfUsers = friendOfUserMapper.selectList(queryWrapper);

        for(FriendOfUser friend : friendOfUsers){
            Integer friendId = friend.getFriendId();
            QueryWrapper<UserInfo> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.lambda().eq(UserInfo::getUserId,friendId);
            UserInfo userInfo = userInfoMapper.selectOne(queryWrapper2);

            resultList.add(MyBeanUtil.transToFriend(userInfo));
        }
        return resultList;
    }
}
