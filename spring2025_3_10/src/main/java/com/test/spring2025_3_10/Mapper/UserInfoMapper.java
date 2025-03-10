package com.test.spring2025_3_10.Mapper;

import com.test.spring2025_3_10.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> selectUserInfo();

    Integer insertUserInfo(UserInfo userInfo);
    Integer insertUserInfo2(UserInfo userInfo);

    UserInfo selectUserInfo2(UserInfo userInfo);

    Integer updateUserInfo(UserInfo userInfo);

    Integer deleteUserInfo(int[] nums);
}
