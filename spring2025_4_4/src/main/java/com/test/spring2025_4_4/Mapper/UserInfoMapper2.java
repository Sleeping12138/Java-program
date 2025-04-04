package com.test.spring2025_4_4.Mapper;

import com.test.spring2025_4_4.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper2 {

    @Select("select * from user_info")
    List<UserInfo> getList();

    UserInfo getUserInfoById(Integer id);
}
