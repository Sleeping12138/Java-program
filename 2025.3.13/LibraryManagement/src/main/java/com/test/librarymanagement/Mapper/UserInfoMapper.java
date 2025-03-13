package com.test.librarymanagement.Mapper;

import com.test.librarymanagement.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user_info where user_name = #{name};")
    UserInfo selectUserInfo(String name);
}
